package acme;

import jakarta.interceptor.InvocationContext;
import jakarta.ws.rs.core.UriInfo;
import java.util.function.BiFunction;

// $VF: synthetic class
public class CalendarRepositoryJaxRs_253b5300496aea63c836aa077421802281ec4c5b_Subclass$$function$$2 implements BiFunction {
   @Override
   public Object apply(Object var1, Object var2) {
      Object[] var3 = ((InvocationContext)var2).getParameters();
      Object var4 = var3[0];
      Object var5 = var3[1];
      Object var6 = var3[2];
      return ((CalendarRepositoryJaxRs_253b5300496aea63c836aa077421802281ec4c5b_Subclass)var1).update$$superforward((Long)var4, (Calendar)var5, (UriInfo)var6);
   }
}
