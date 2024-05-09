package acme;

import jakarta.interceptor.InvocationContext;
import java.util.function.BiFunction;

// $VF: synthetic class
public class AuthorsRepository_e12acf7985d291f8b895b3918294612f06ce6513Impl_Subclass$$function$$5 implements BiFunction {
   @Override
   public Object apply(Object var1, Object var2) {
      Object var3 = ((InvocationContext)var2).getParameters()[0];
      ((AuthorsRepository_e12acf7985d291f8b895b3918294612f06ce6513Impl_Subclass)var1).deleteAll$$superforward((Iterable)var3);
      return null;
   }
}
