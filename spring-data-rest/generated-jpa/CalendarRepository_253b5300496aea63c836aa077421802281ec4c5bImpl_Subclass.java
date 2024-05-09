package acme;

import io.quarkus.arc.ArcUndeclaredThrowableException;
import io.quarkus.arc.InjectableInterceptor;
import io.quarkus.arc.InjectableReferenceProvider;
import io.quarkus.arc.Subclass;
import io.quarkus.arc.impl.AnnotationLiterals;
import io.quarkus.arc.impl.CreationalContextImpl;
import io.quarkus.arc.impl.InterceptedMethodMetadata;
import io.quarkus.arc.impl.InterceptorInvocation;
import io.quarkus.arc.impl.InvocationContexts;
import io.quarkus.arc.impl.Reflections;
import jakarta.enterprise.context.spi.CreationalContext;
import jakarta.transaction.Transactional_ArcAnnotationLiteral;
import jakarta.transaction.Transactional.TxType;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// $VF: synthetic class
public class CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_Subclass
   extends CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl
   implements Subclass {
   private volatile boolean arc$constructed;
   private InterceptedMethodMetadata arc$1;
   private InterceptedMethodMetadata arc$2;
   private InterceptedMethodMetadata arc$3;
   private InterceptedMethodMetadata arc$4;
   private InterceptedMethodMetadata arc$5;
   private InterceptedMethodMetadata arc$6;
   private InterceptedMethodMetadata arc$7;
   private InterceptedMethodMetadata arc$8;
   private InterceptedMethodMetadata arc$9;

   public CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_Subclass(CreationalContext var1, InjectableInterceptor var2) {
      CreationalContextImpl var3 = CreationalContextImpl.child(var1);
      Object var4 = ((InjectableReferenceProvider)var2).get((CreationalContext)var3);
      HashMap var5 = new HashMap();
      HashMap var10 = new HashMap();
      List var6 = Collections.singletonList(InterceptorInvocation.aroundInvoke(var2, var4));
      var5.put("i1", var6);
      TxType var7 = TxType.REQUIRED;
      Class[] var8 = AnnotationLiterals.EMPTY_CLASS_ARRAY;
      Class[] var9 = AnnotationLiterals.EMPTY_CLASS_ARRAY;
      Set var11 = Collections.singleton(new Transactional_ArcAnnotationLiteral(var7, var8, var9));
      var10.put("b1", var11);
      this.arc$initMetadata0(var5, var10);
   }

   public Calendar save$$superforward(Calendar var1) {
      return super.save(var1);
   }

   public Calendar saveAndFlush$$superforward(Calendar var1) {
      return super.saveAndFlush(var1);
   }

   public List saveAll$$superforward(Iterable var1) {
      return super.saveAll(var1);
   }

   public void delete$$superforward(Calendar var1) {
      super.delete(var1);
   }

   public void deleteAll$$superforward() {
      super.deleteAll();
   }

   public void deleteAll$$superforward(Iterable var1) {
      super.deleteAll(var1);
   }

   public void deleteAllInBatch$$superforward() {
      super.deleteAllInBatch();
   }

   public void deleteById$$superforward(Long var1) {
      super.deleteById(var1);
   }

   public void flush$$superforward() {
      super.flush();
   }

   public void arc$markConstructed() {
      this.arc$constructed = true;
   }

   private void arc$initMetadata0(Map var1, Map var2) {
      Object var4 = var1.get("i1");
      Class[] var3 = new Class[]{Calendar.class};
      Method var5 = Reflections.findMethod(CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl.class, "save", var3);
      Object var6 = var2.get("b1");
      CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_Subclass$$function$$1 var7 = new CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_Subclass$$function$$1(
         
      );
      InterceptedMethodMetadata var8 = new InterceptedMethodMetadata((List)var4, var5, (Set)var6, var7);
      this.arc$1 = var8;
      Class[] var9 = new Class[]{Calendar.class};
      Method var10 = Reflections.findMethod(CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl.class, "saveAndFlush", var9);
      CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_Subclass$$function$$2 var11 = new CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_Subclass$$function$$2(
         
      );
      InterceptedMethodMetadata var12 = new InterceptedMethodMetadata((List)var4, var10, (Set)var6, var11);
      this.arc$2 = var12;
      Class[] var13 = new Class[]{Iterable.class};
      Method var14 = Reflections.findMethod(CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl.class, "saveAll", var13);
      CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_Subclass$$function$$3 var15 = new CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_Subclass$$function$$3(
         
      );
      InterceptedMethodMetadata var16 = new InterceptedMethodMetadata((List)var4, var14, (Set)var6, var15);
      this.arc$3 = var16;
      Class[] var17 = new Class[]{Calendar.class};
      Method var18 = Reflections.findMethod(CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl.class, "delete", var17);
      CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_Subclass$$function$$4 var19 = new CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_Subclass$$function$$4(
         
      );
      InterceptedMethodMetadata var20 = new InterceptedMethodMetadata((List)var4, var18, (Set)var6, var19);
      this.arc$4 = var20;
      Class[] var21 = AnnotationLiterals.EMPTY_CLASS_ARRAY;
      Method var22 = Reflections.findMethod(CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl.class, "deleteAll", var21);
      CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_Subclass$$function$$5 var23 = new CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_Subclass$$function$$5(
         
      );
      InterceptedMethodMetadata var24 = new InterceptedMethodMetadata((List)var4, var22, (Set)var6, var23);
      this.arc$5 = var24;
      Class[] var25 = new Class[]{Iterable.class};
      Method var26 = Reflections.findMethod(CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl.class, "deleteAll", var25);
      CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_Subclass$$function$$6 var27 = new CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_Subclass$$function$$6(
         
      );
      InterceptedMethodMetadata var28 = new InterceptedMethodMetadata((List)var4, var26, (Set)var6, var27);
      this.arc$6 = var28;
      Class[] var29 = AnnotationLiterals.EMPTY_CLASS_ARRAY;
      Method var30 = Reflections.findMethod(CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl.class, "deleteAllInBatch", var29);
      CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_Subclass$$function$$7 var31 = new CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_Subclass$$function$$7(
         
      );
      InterceptedMethodMetadata var32 = new InterceptedMethodMetadata((List)var4, var30, (Set)var6, var31);
      this.arc$7 = var32;
      Class[] var33 = new Class[]{Long.class};
      Method var34 = Reflections.findMethod(CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl.class, "deleteById", var33);
      CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_Subclass$$function$$8 var35 = new CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_Subclass$$function$$8(
         
      );
      InterceptedMethodMetadata var36 = new InterceptedMethodMetadata((List)var4, var34, (Set)var6, var35);
      this.arc$8 = var36;
      Class[] var37 = AnnotationLiterals.EMPTY_CLASS_ARRAY;
      Method var38 = Reflections.findMethod(CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl.class, "flush", var37);
      CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_Subclass$$function$$9 var39 = new CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_Subclass$$function$$9(
         
      );
      InterceptedMethodMetadata var40 = new InterceptedMethodMetadata((List)var4, var38, (Set)var6, var39);
      this.arc$9 = var40;
   }

   @Override
   public Calendar save(Calendar var1) {
      Object[] var2 = new Object[]{var1};
      if (this.arc$constructed) {
         try {
            InterceptedMethodMetadata var3 = this.arc$1;
            return (Calendar)InvocationContexts.performAroundInvoke(this, var2, var3);
         } catch (RuntimeException var6) {
            throw (Throwable)var6;
         } catch (Exception var7) {
            throw (Throwable)(new ArcUndeclaredThrowableException("Error invoking subclass method", var7));
         }
      } else {
         return this.save$$superforward(var1);
      }
   }

   @Override
   public Calendar saveAndFlush(Calendar var1) {
      Object[] var2 = new Object[]{var1};
      if (this.arc$constructed) {
         try {
            InterceptedMethodMetadata var3 = this.arc$2;
            return (Calendar)InvocationContexts.performAroundInvoke(this, var2, var3);
         } catch (RuntimeException var6) {
            throw (Throwable)var6;
         } catch (Exception var7) {
            throw (Throwable)(new ArcUndeclaredThrowableException("Error invoking subclass method", var7));
         }
      } else {
         return this.saveAndFlush$$superforward(var1);
      }
   }

   @Override
   public List saveAll(Iterable var1) {
      Object[] var2 = new Object[]{var1};
      if (this.arc$constructed) {
         try {
            InterceptedMethodMetadata var3 = this.arc$3;
            return (List)InvocationContexts.performAroundInvoke(this, var2, var3);
         } catch (RuntimeException var6) {
            throw (Throwable)var6;
         } catch (Exception var7) {
            throw (Throwable)(new ArcUndeclaredThrowableException("Error invoking subclass method", var7));
         }
      } else {
         return this.saveAll$$superforward(var1);
      }
   }

   @Override
   public void delete(Calendar var1) {
      Object[] var2 = new Object[]{var1};
      if (this.arc$constructed) {
         try {
            InterceptedMethodMetadata var3 = this.arc$4;
            InvocationContexts.performAroundInvoke(this, var2, var3);
         } catch (RuntimeException var6) {
            throw (Throwable)var6;
         } catch (Exception var7) {
            throw (Throwable)(new ArcUndeclaredThrowableException("Error invoking subclass method", var7));
         }
      } else {
         this.delete$$superforward(var1);
      }
   }

   @Override
   public void deleteAll() {
      if (this.arc$constructed) {
         try {
            InterceptedMethodMetadata var1 = this.arc$5;
            InvocationContexts.performAroundInvoke(this, null, var1);
         } catch (RuntimeException var4) {
            throw (Throwable)var4;
         } catch (Exception var5) {
            throw (Throwable)(new ArcUndeclaredThrowableException("Error invoking subclass method", var5));
         }
      } else {
         this.deleteAll$$superforward();
      }
   }

   @Override
   public void deleteAll(Iterable var1) {
      Object[] var2 = new Object[]{var1};
      if (this.arc$constructed) {
         try {
            InterceptedMethodMetadata var3 = this.arc$6;
            InvocationContexts.performAroundInvoke(this, var2, var3);
         } catch (RuntimeException var6) {
            throw (Throwable)var6;
         } catch (Exception var7) {
            throw (Throwable)(new ArcUndeclaredThrowableException("Error invoking subclass method", var7));
         }
      } else {
         this.deleteAll$$superforward(var1);
      }
   }

   @Override
   public void deleteAllInBatch() {
      if (this.arc$constructed) {
         try {
            InterceptedMethodMetadata var1 = this.arc$7;
            InvocationContexts.performAroundInvoke(this, null, var1);
         } catch (RuntimeException var4) {
            throw (Throwable)var4;
         } catch (Exception var5) {
            throw (Throwable)(new ArcUndeclaredThrowableException("Error invoking subclass method", var5));
         }
      } else {
         this.deleteAllInBatch$$superforward();
      }
   }

   @Override
   public void deleteById(Long var1) {
      Object[] var2 = new Object[]{var1};
      if (this.arc$constructed) {
         try {
            InterceptedMethodMetadata var3 = this.arc$8;
            InvocationContexts.performAroundInvoke(this, var2, var3);
         } catch (RuntimeException var6) {
            throw (Throwable)var6;
         } catch (Exception var7) {
            throw (Throwable)(new ArcUndeclaredThrowableException("Error invoking subclass method", var7));
         }
      } else {
         this.deleteById$$superforward(var1);
      }
   }

   @Override
   public void flush() {
      if (this.arc$constructed) {
         try {
            InterceptedMethodMetadata var1 = this.arc$9;
            InvocationContexts.performAroundInvoke(this, null, var1);
         } catch (RuntimeException var4) {
            throw (Throwable)var4;
         } catch (Exception var5) {
            throw (Throwable)(new ArcUndeclaredThrowableException("Error invoking subclass method", var5));
         }
      } else {
         this.flush$$superforward();
      }
   }
}
