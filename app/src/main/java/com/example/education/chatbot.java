package com.example.education;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class chatbot extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EditText editText;
    private ArrayList<MessageModel> list;
    private ChatRVAdapter adapter;
    private ProgressBar progressBar;  // Added ProgressBar for loading indicator
    private final String user = "user";
    private final String bot = "bot";

    private OpenAIApi openAIApi;

    // Your OpenAI API Key (you should secure this key)
    private final String API_KEY = "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";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbot);

        // Initialize Retrofit with API key interceptor
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(chain -> {
            Request request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer " + API_KEY)
                    .build();
            return chain.proceed(request);
        }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openai.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        openAIApi = retrofit.create(OpenAIApi.class);

        // Handle window insets for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize UI components
        recyclerView = findViewById(R.id.recycleview);
        editText = findViewById(R.id.edit);
        progressBar = findViewById(R.id.progressBar);  // Initialize ProgressBar
        progressBar.setVisibility(View.GONE);  // Hide ProgressBar initially

        list = new ArrayList<>();
        adapter = new ChatRVAdapter(this, list);

        // Setup RecyclerView
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        // Handle sending message on touching the send button or icon in the EditText
        findViewById(R.id.sendbtnn).setOnClickListener(view -> sendMessage());

        editText.setOnTouchListener((view, motionEvent) -> {
            if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                if (motionEvent.getRawX() >= (editText.getRight() - (editText.getCompoundDrawables()[2] != null ? editText.getCompoundDrawables()[2].getBounds().width() : 0))) {
                    sendMessage();
                    return true;
                }
            }
            return false;
        });
    }

    private void sendMessage() {
        String message = editText.getText().toString().trim();
        if (!message.isEmpty()) {
            // Add user message to the list
            list.add(new MessageModel(message, user));
            adapter.notifyDataSetChanged();
            recyclerView.scrollToPosition(list.size() - 1);
            editText.setText("");

            // Show loading indicator
            progressBar.setVisibility(View.VISIBLE);

            // Create the OpenAI request
            OpenAIRequest openAIRequest = new OpenAIRequest("gpt-3.5-turbo", Collections.singletonList(new OpenAIRequest.Message(user, message))
            );

            // Call the API
            openAIApi.getResponse(openAIRequest).enqueue(new Callback<OpenAIResponse>() {
                @Override
                public void onResponse(Call<OpenAIResponse> call, Response<OpenAIResponse> response) {
                    // Hide loading indicator
                    progressBar.setVisibility(View.GONE);

                    if (response.isSuccessful() && response.body() != null) {
                        String botMessage = response.body().getChoices().get(0).getMessage().getContent();
                        list.add(new MessageModel(botMessage, bot));
                        adapter.notifyDataSetChanged();
                        recyclerView.scrollToPosition(list.size() - 1);
                    } else {
                        botReply("Hey ! There is a Tecnical issue so I can't responce your Question");
                    }
                }

                @Override
                public void onFailure(Call<OpenAIResponse> call, Throwable t) {
                    // Hide loading indicator
                    progressBar.setVisibility(View.GONE);
                    botReply("Failed to connect to the server. Please try again later.");
                }
            });
        }
    }

    private void botReply(String message) {
        list.add(new MessageModel(message, bot));
        adapter.notifyDataSetChanged();
        recyclerView.scrollToPosition(list.size() - 1);
    }
}
