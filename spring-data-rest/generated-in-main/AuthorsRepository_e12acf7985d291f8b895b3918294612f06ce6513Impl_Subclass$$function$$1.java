package acme;

import jakarta.interceptor.InvocationContext;
import java.util.function.BiFunction;

// $VF: synthetic class
public class AuthorsRepository_e12acf7985d291f8b895b3918294612f06ce6513Impl_Subclass$$function$$1 implements BiFunction {
   @Override
   public Object apply(Object var1, Object var2) {
      Object var3 = ((InvocationContext)var2).getParameters()[0];
      return ((AuthorsRepository_e12acf7985d291f8b895b3918294612f06ce6513Impl_Subclass)var1).save$$superforward((Author)var3);
   }
}
