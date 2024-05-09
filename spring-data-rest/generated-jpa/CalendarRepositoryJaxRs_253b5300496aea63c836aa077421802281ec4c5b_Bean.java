package acme;

import io.quarkus.arc.Arc;
import io.quarkus.arc.ArcContainer;
import io.quarkus.arc.InjectableBean;
import io.quarkus.arc.InjectableInterceptor;
import io.quarkus.arc.InjectableReferenceProvider;
import io.quarkus.arc.impl.Beans;
import io.quarkus.arc.impl.CreationalContextImpl;
import io.quarkus.arc.impl.Sets;
import jakarta.enterprise.context.spi.Context;
import jakarta.enterprise.context.spi.Contextual;
import jakarta.enterprise.context.spi.CreationalContext;
import jakarta.enterprise.inject.CreationException;
import jakarta.inject.Singleton;
import java.util.Set;
import java.util.function.Supplier;

// $VF: synthetic class
public class CalendarRepositoryJaxRs_253b5300496aea63c836aa077421802281ec4c5b_Bean implements InjectableBean, Supplier {
   private final Set types;
   private final Supplier injectProviderSupplier1;
   private final Supplier interceptorProviderSupplier2;

   public CalendarRepositoryJaxRs_253b5300496aea63c836aa077421802281ec4c5b_Bean(Supplier var1, Supplier var2) {
      ClassLoader var3 = Thread.currentThread().getContextClassLoader();
      this.injectProviderSupplier1 = var1;
      this.interceptorProviderSupplier2 = var2;
      Object[] var4 = new Object[2];
      Class var5 = Class.forName("acme.CalendarRepositoryJaxRs_253b5300496aea63c836aa077421802281ec4c5b", false, var3);
      var4[0] = var5;
      Class<Object> var6 = Object.class;
      var4[1] = var6;
      Set var7 = Sets.of(var4);
      this.types = var7;
   }

   public String getIdentifier() {
      return "WyYmhmmEMBVn3RBHdkZP0nFJG_Q";
   }

   @Override
   public Object get() {
      return this;
   }

   private CalendarRepositoryJaxRs_253b5300496aea63c836aa077421802281ec4c5b doCreate(CreationalContext var1) {
      Object var2 = this.interceptorProviderSupplier2.get();
      CalendarRepositoryJaxRs_253b5300496aea63c836aa077421802281ec4c5b var5 = new CalendarRepositoryJaxRs_253b5300496aea63c836aa077421802281ec4c5b_Subclass(
         var1, (InjectableInterceptor)var2
      );

      try {
         Object var3 = this.injectProviderSupplier1.get();
         CreationalContextImpl var4 = CreationalContextImpl.child((InjectableReferenceProvider)var3, var1);
         Object var6 = ((InjectableReferenceProvider)var3).get((CreationalContext)var4);
         var5.resource = (CalendarRepositoryResourceImpl_253b5300496aea63c836aa077421802281ec4c5b)var6;
      } catch (RuntimeException var8) {
         throw (Throwable)(
            new RuntimeException(
               "Error injecting acme.CalendarRepositoryResourceImpl_253b5300496aea63c836aa077421802281ec4c5b acme.CalendarRepositoryJaxRs_253b5300496aea63c836aa077421802281ec4c5b.resource",
               var8
            )
         );
      }

      ((CalendarRepositoryJaxRs_253b5300496aea63c836aa077421802281ec4c5b_Subclass)var5).arc$markConstructed();
      return var5;
   }

   public CalendarRepositoryJaxRs_253b5300496aea63c836aa077421802281ec4c5b create(CreationalContext var1) {
      try {
         return this.doCreate(var1);
      } catch (Exception var3) {
         if (var3 instanceof RuntimeException) {
            throw (Throwable)var3;
         } else {
            throw (Throwable)(new CreationException(var3));
         }
      }
   }

   // $VF: bridge method
   public Object create(CreationalContext var1) {
      return this.create(var1);
   }

   public CalendarRepositoryJaxRs_253b5300496aea63c836aa077421802281ec4c5b get(CreationalContext var1) {
      ArcContainer var2 = Arc.container();
      CreationalContextImpl var3 = new CreationalContextImpl((Contextual)this);
      return (CalendarRepositoryJaxRs_253b5300496aea63c836aa077421802281ec4c5b)((Context)var2.getActiveContext(Singleton.class))
         .get((Contextual)this, (CreationalContext)var3);
   }

   // $VF: bridge method
   public Object get(CreationalContext var1) {
      return this.get(var1);
   }

   public Set getTypes() {
      return this.types;
   }

   public Class getScope() {
      return Singleton.class;
   }

   public Class getBeanClass() {
      return CalendarRepositoryJaxRs_253b5300496aea63c836aa077421802281ec4c5b.class;
   }

   public boolean isSuppressed() {
      return false;
   }

   @Override
   public boolean equals(Object var1) {
      if (this != var1) {
         if (var1 != null) {
            if (var1 instanceof InjectableBean) {
               String var2 = ((InjectableBean)var1).getIdentifier();
               return "WyYmhmmEMBVn3RBHdkZP0nFJG_Q".equals(var2);
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   @Override
   public int hashCode() {
      return -822433483;
   }

   @Override
   public String toString() {
      return Beans.toString(this);
   }
}
