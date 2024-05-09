package acme;

import jakarta.interceptor.InvocationContext;
import java.util.function.BiFunction;

// $VF: synthetic class
public class CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_Subclass$$function$$1 implements BiFunction {
   @Override
   public Object apply(Object var1, Object var2) {
      Object var3 = ((InvocationContext)var2).getParameters()[0];
      return ((CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_Subclass)var1).save$$superforward((Calendar)var3);
   }
}
