package acme;

import jakarta.interceptor.InvocationContext;
import jakarta.ws.rs.core.UriInfo;
import java.util.function.BiFunction;

// $VF: synthetic class
public class BooksRepositoryJaxRs_d9a8b98a40e4766003932d142b1d4907d02a3c8f_Subclass$$function$$1 implements BiFunction {
   @Override
   public Object apply(Object var1, Object var2) {
      Object[] var3 = ((InvocationContext)var2).getParameters();
      Object var4 = var3[0];
      Object var5 = var3[1];
      return ((BooksRepositoryJaxRs_d9a8b98a40e4766003932d142b1d4907d02a3c8f_Subclass)var1).add$$superforward((Book)var4, (UriInfo)var5);
   }
}
