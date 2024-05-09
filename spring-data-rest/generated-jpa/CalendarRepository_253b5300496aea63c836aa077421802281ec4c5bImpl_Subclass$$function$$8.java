package acme;

import jakarta.interceptor.InvocationContext;
import java.util.function.BiFunction;

// $VF: synthetic class
public class CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_Subclass$$function$$8 implements BiFunction {
   @Override
   public Object apply(Object var1, Object var2) {
      Object var3 = ((InvocationContext)var2).getParameters()[0];
      ((CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_Subclass)var1).deleteById$$superforward((Long)var3);
      return null;
   }
}
