package acme;

import io.quarkus.arc.ArcUndeclaredThrowableException;
import io.quarkus.arc.InjectableInterceptor;
import io.quarkus.arc.InjectableReferenceProvider;
import io.quarkus.arc.Subclass;
import io.quarkus.arc.impl.CreationalContextImpl;
import io.quarkus.arc.impl.InterceptedMethodMetadata;
import io.quarkus.arc.impl.InterceptorInvocation;
import io.quarkus.arc.impl.InvocationContexts;
import io.quarkus.arc.impl.Reflections;
import io.quarkus.hibernate.validator.runtime.jaxrs.JaxrsEndPointValidated_ArcAnnotationLiteral;
import jakarta.enterprise.context.spi.CreationalContext;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// $VF: synthetic class
public class CalendarRepositoryJaxRs_253b5300496aea63c836aa077421802281ec4c5b_Subclass
   extends CalendarRepositoryJaxRs_253b5300496aea63c836aa077421802281ec4c5b
   implements Subclass {
   private volatile boolean arc$constructed;
   private InterceptedMethodMetadata arc$1;
   private InterceptedMethodMetadata arc$2;

   public CalendarRepositoryJaxRs_253b5300496aea63c836aa077421802281ec4c5b_Subclass(CreationalContext var1, InjectableInterceptor var2) {
      CreationalContextImpl var3 = CreationalContextImpl.child(var1);
      Object var4 = ((InjectableReferenceProvider)var2).get((CreationalContext)var3);
      HashMap var5 = new HashMap();
      HashMap var7 = new HashMap();
      List var6 = Collections.singletonList(InterceptorInvocation.aroundInvoke(var2, var4));
      var5.put("i1", var6);
      Set var8 = Collections.singleton(JaxrsEndPointValidated_ArcAnnotationLiteral.INSTANCE);
      var7.put("b1", var8);
      this.arc$initMetadata0(var5, var7);
   }

   public Response add$$superforward(Calendar var1, UriInfo var2) {
      return super.add(var1, var2);
   }

   public Response update$$superforward(Long var1, Calendar var2, UriInfo var3) {
      return super.update(var1, var2, var3);
   }

   public void arc$markConstructed() {
      this.arc$constructed = true;
   }

   private void arc$initMetadata0(Map var1, Map var2) {
      Object var4 = var1.get("i1");
      Class[] var3 = new Class[]{Calendar.class, UriInfo.class};
      Method var5 = Reflections.findMethod(CalendarRepositoryJaxRs_253b5300496aea63c836aa077421802281ec4c5b.class, "add", var3);
      Object var6 = var2.get("b1");
      CalendarRepositoryJaxRs_253b5300496aea63c836aa077421802281ec4c5b_Subclass$$function$$1 var7 = new CalendarRepositoryJaxRs_253b5300496aea63c836aa077421802281ec4c5b_Subclass$$function$$1(
         
      );
      InterceptedMethodMetadata var8 = new InterceptedMethodMetadata((List)var4, var5, (Set)var6, var7);
      this.arc$1 = var8;
      Class[] var9 = new Class[]{Long.class, Calendar.class, UriInfo.class};
      Method var10 = Reflections.findMethod(CalendarRepositoryJaxRs_253b5300496aea63c836aa077421802281ec4c5b.class, "update", var9);
      CalendarRepositoryJaxRs_253b5300496aea63c836aa077421802281ec4c5b_Subclass$$function$$2 var11 = new CalendarRepositoryJaxRs_253b5300496aea63c836aa077421802281ec4c5b_Subclass$$function$$2(
         
      );
      InterceptedMethodMetadata var12 = new InterceptedMethodMetadata((List)var4, var10, (Set)var6, var11);
      this.arc$2 = var12;
   }

   @Override
   public Response add(Calendar var1, UriInfo var2) {
      Object[] var3 = new Object[]{var1, var2};
      if (this.arc$constructed) {
         try {
            InterceptedMethodMetadata var4 = this.arc$1;
            return (Response)InvocationContexts.performAroundInvoke(this, var3, var4);
         } catch (RuntimeException var7) {
            throw (Throwable)var7;
         } catch (Exception var8) {
            throw (Throwable)(new ArcUndeclaredThrowableException("Error invoking subclass method", var8));
         }
      } else {
         return this.add$$superforward(var1, var2);
      }
   }

   @Override
   public Response update(Long var1, Calendar var2, UriInfo var3) {
      Object[] var4 = new Object[]{var1, var2, var3};
      if (this.arc$constructed) {
         try {
            InterceptedMethodMetadata var5 = this.arc$2;
            return (Response)InvocationContexts.performAroundInvoke(this, var4, var5);
         } catch (RuntimeException var8) {
            throw (Throwable)var8;
         } catch (Exception var9) {
            throw (Throwable)(new ArcUndeclaredThrowableException("Error invoking subclass method", var9));
         }
      } else {
         return this.update$$superforward(var1, var2, var3);
      }
   }
}
