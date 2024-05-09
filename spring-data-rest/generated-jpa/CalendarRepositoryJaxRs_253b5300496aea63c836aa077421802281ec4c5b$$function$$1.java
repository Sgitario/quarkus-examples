package acme;

import java.util.function.Supplier;

// $VF: synthetic class
public class CalendarRepositoryJaxRs_253b5300496aea63c836aa077421802281ec4c5b$$function$$1 implements Supplier {
   private final Calendar f0;
   private final CalendarRepositoryResourceImpl_253b5300496aea63c836aa077421802281ec4c5b f1;
   private final Long f2;

   @Override
   public Object get() {
      Calendar var3 = this.f0;
      CalendarRepositoryResourceImpl_253b5300496aea63c836aa077421802281ec4c5b var1 = this.f1;
      Long var2 = this.f2;
      if (var1.get(var2) == null) {
         return var1.update(var2, var3);
      } else {
         var1.update(var2, var3);
         return null;
      }
   }

   public CalendarRepositoryJaxRs_253b5300496aea63c836aa077421802281ec4c5b$$function$$1(
      Calendar var1, CalendarRepositoryResourceImpl_253b5300496aea63c836aa077421802281ec4c5b var2, Long var3
   ) {
      this.f0 = var1;
      this.f1 = var2;
      this.f2 = var3;
   }
}
