package acme;

import jakarta.interceptor.InvocationContext;
import java.util.function.BiFunction;

// $VF: synthetic class
public class BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl_Subclass$$function$$3 implements BiFunction {
   @Override
   public Object apply(Object var1, Object var2) {
      Object var3 = ((InvocationContext)var2).getParameters()[0];
      ((BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl_Subclass)var1).delete$$superforward((Book)var3);
      return null;
   }
}
