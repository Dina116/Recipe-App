package com.training.recipeapp.home;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0013B\'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\b2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/training/recipeapp/home/RecipeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/training/recipeapp/home/RecipeAdapter$RecipeViewHolder;", "recipes", "", "Lcom/training/recipeapp/home/Recipe;", "onItemClick", "Lkotlin/Function1;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "RecipeViewHolder", "app_debug"})
@kotlin.Suppress(names = {"DEPRECATION"})
public final class RecipeAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.training.recipeapp.home.RecipeAdapter.RecipeViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.training.recipeapp.home.Recipe> recipes = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function1<com.training.recipeapp.home.Recipe, kotlin.Unit> onItemClick = null;
    
    public RecipeAdapter(@org.jetbrains.annotations.NotNull
    java.util.List<com.training.recipeapp.home.Recipe> recipes, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.training.recipeapp.home.Recipe, kotlin.Unit> onItemClick) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.training.recipeapp.home.RecipeAdapter.RecipeViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.training.recipeapp.home.RecipeAdapter.RecipeViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/training/recipeapp/home/RecipeAdapter$RecipeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/training/recipeapp/home/RecipeAdapter;Landroid/view/View;)V", "recipeImage1", "Landroid/widget/ImageView;", "recipeImage2", "recipeName1", "Landroid/widget/TextView;", "recipeName2", "bindRecipe1", "", "recipe", "Lcom/training/recipeapp/home/Recipe;", "bindRecipe2", "app_debug"})
    public final class RecipeViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView recipeName1 = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.ImageView recipeImage1 = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView recipeName2 = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.ImageView recipeImage2 = null;
        
        public RecipeViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        public final void bindRecipe1(@org.jetbrains.annotations.NotNull
        com.training.recipeapp.home.Recipe recipe) {
        }
        
        public final void bindRecipe2(@org.jetbrains.annotations.NotNull
        com.training.recipeapp.home.Recipe recipe) {
        }
    }
}