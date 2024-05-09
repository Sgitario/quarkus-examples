package acme;

import java.util.function.Supplier;

// $VF: synthetic class
public class BooksRepositoryJaxRs_d9a8b98a40e4766003932d142b1d4907d02a3c8f$$function$$1 implements Supplier {
   private final Book f0;
   private final BooksRepositoryResourceImpl_d9a8b98a40e4766003932d142b1d4907d02a3c8f f1;
   private final Long f2;

   @Override
   public Object get() {
      Book var3 = this.f0;
      BooksRepositoryResourceImpl_d9a8b98a40e4766003932d142b1d4907d02a3c8f var1 = this.f1;
      Long var2 = this.f2;
      if (var1.get(var2) == null) {
         return var1.update(var2, var3);
      } else {
         var1.update(var2, var3);
         return null;
      }
   }

   public BooksRepositoryJaxRs_d9a8b98a40e4766003932d142b1d4907d02a3c8f$$function$$1(
      Book var1, BooksRepositoryResourceImpl_d9a8b98a40e4766003932d142b1d4907d02a3c8f var2, Long var3
   ) {
      this.f0 = var1;
      this.f1 = var2;
      this.f2 = var3;
   }
}
