package com.training.recipeapp.home;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/training/recipeapp/home/RecipeDetailActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "apiService", "Lcom/training/recipeapp/home/ApiService;", "recipeImageView", "Landroid/widget/ImageView;", "recipeInstructionsTextView", "Landroid/widget/TextView;", "recipeNameTextView", "fetchRecipeById", "", "id", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class RecipeDetailActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.training.recipeapp.home.ApiService apiService;
    private android.widget.ImageView recipeImageView;
    private android.widget.TextView recipeNameTextView;
    private android.widget.TextView recipeInstructionsTextView;
    
    public RecipeDetailActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void fetchRecipeById(java.lang.String id) {
    }
}