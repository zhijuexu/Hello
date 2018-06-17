package me.nim.hello;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import me.nim.hello.databinding.ActivityRecyclerBinding;
import me.nim.hello.databinding.LayoutBoxBinding;
import me.nim.hello.databinding.LayoutItemBinding;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityRecyclerBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler);

        binding.list.setHasFixedSize(true);
        binding.list.setLayoutManager(new LinearLayoutManager(this));
        binding.list.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                int layout = viewType == 0 ? R.layout.layout_item : R.layout.layout_box;

                ViewDataBinding binding = DataBindingUtil.inflate(
                        LayoutInflater.from(parent.getContext()), layout, parent, false);

                if (viewType == 1) {
                    LayoutBoxBinding bb = (LayoutBoxBinding) binding;
                    bb.list.setHasFixedSize(true);
                    bb.list.setLayoutManager(new LinearLayoutManager(RecyclerActivity.this));
                    bb.list.setAdapter(new RecyclerView.Adapter() {
                        @NonNull
                        @Override
                        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                            LayoutItemBinding binding = DataBindingUtil.inflate(
                                    LayoutInflater.from(parent.getContext()), R.layout.layout_item, parent, false);

                            return new RecyclerView.ViewHolder(binding.getRoot()) {
                                @Override
                                public String toString() {
                                    return super.toString();
                                }
                            };
                        }

                        @Override
                        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

                        }

                        @Override
                        public int getItemCount() {
                            return 7;
                        }
                    });

                }

                return new RecyclerView.ViewHolder(binding.getRoot()) {
                    @Override
                    public String toString() {
                        return super.toString();
                    }
                };
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return 8;
            }

            @Override
            public int getItemViewType(int position) {
                return position != 4 ? 0 : 1;
            }
        });
    }
}
