package com.training.recipeapp;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/training/recipeapp/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "userViewModel", "Lcom/training/recipeapp/data/UserViewModel;", "applyFontToMenuItem", "", "menu", "Landroid/view/Menu;", "clearUserData", "loadFragment", "fragment", "Landroidx/fragment/app/Fragment;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "signOut", "CustomTypefaceSpan", "app_debug"})
@kotlin.Suppress(names = {"DEPRECATION"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.training.recipeapp.data.UserViewModel userViewModel;
    
    public MainActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void loadFragment(androidx.fragment.app.Fragment fragment) {
    }
    
    @java.lang.Override
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.Nullable
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    private final void signOut() {
    }
    
    private final void clearUserData() {
    }
    
    private final void applyFontToMenuItem(android.view.Menu menu) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/training/recipeapp/MainActivity$CustomTypefaceSpan;", "Landroid/text/style/TypefaceSpan;", "family", "", "newType", "Landroid/graphics/Typeface;", "(Ljava/lang/String;Landroid/graphics/Typeface;)V", "applyCustomTypeFace", "", "paint", "Landroid/graphics/Paint;", "tf", "updateDrawState", "ds", "Landroid/text/TextPaint;", "updateMeasureState", "app_debug"})
    static final class CustomTypefaceSpan extends android.text.style.TypefaceSpan {
        @org.jetbrains.annotations.NotNull
        private final android.graphics.Typeface newType = null;
        
        public CustomTypefaceSpan(@org.jetbrains.annotations.NotNull
        java.lang.String family, @org.jetbrains.annotations.NotNull
        android.graphics.Typeface newType) {
            super(null);
        }
        
        @java.lang.Override
        public void updateDrawState(@org.jetbrains.annotations.NotNull
        android.text.TextPaint ds) {
        }
        
        @java.lang.Override
        public void updateMeasureState(@org.jetbrains.annotations.NotNull
        android.text.TextPaint paint) {
        }
        
        private final void applyCustomTypeFace(android.graphics.Paint paint, android.graphics.Typeface tf) {
        }
    }
}