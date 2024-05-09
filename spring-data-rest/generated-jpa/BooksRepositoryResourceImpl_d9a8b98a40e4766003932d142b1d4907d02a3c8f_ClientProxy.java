package acme;

import io.quarkus.arc.Arc;
import io.quarkus.arc.ArcContainer;
import io.quarkus.arc.ClientProxy;
import io.quarkus.arc.InjectableBean;
import io.quarkus.arc.InjectableContext;
import io.quarkus.arc.impl.ClientProxies;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import java.util.List;
import java.util.Map;

// $VF: synthetic class
public class BooksRepositoryResourceImpl_d9a8b98a40e4766003932d142b1d4907d02a3c8f_ClientProxy
   extends BooksRepositoryResourceImpl_d9a8b98a40e4766003932d142b1d4907d02a3c8f
   implements ClientProxy {
   private final InjectableBean bean;
   private final InjectableContext context;

   public BooksRepositoryResourceImpl_d9a8b98a40e4766003932d142b1d4907d02a3c8f_ClientProxy(String var1) {
      ArcContainer var3 = Arc.container();
      InjectableBean var2 = var3.bean(var1);
      this.bean = var2;
      Class var4 = var2.getScope();
      Object var5 = var3.getContexts(var4).get(0);
      this.context = (InjectableContext)var5;
   }

   private BooksRepositoryResourceImpl_d9a8b98a40e4766003932d142b1d4907d02a3c8f arc$delegate() {
      InjectableBean var1 = this.bean;
      return (BooksRepositoryResourceImpl_d9a8b98a40e4766003932d142b1d4907d02a3c8f)ClientProxies.getApplicationScopedDelegate(this.context, var1);
   }

   public Object arc_contextualInstance() {
      return this.arc$delegate();
   }

   public InjectableBean arc_bean() {
      return this.bean;
   }

   @Override
   public int $$_page_count_update(Page var1) {
      return this.bean != null ? this.arc$delegate().$$_page_count_update(var1) : super.$$_page_count_update(var1);
   }

   public long count() {
      return this.bean != null ? this.arc$delegate().count() : super.count();
   }

   @Override
   public String toString() {
      return this.bean != null ? this.arc$delegate().toString() : super.toString();
   }

   @Override
   public int $$_page_count_list(Page var1) {
      return this.bean != null ? this.arc$delegate().$$_page_count_list(var1) : super.$$_page_count_list(var1);
   }

   public Entity update(ID var1, Entity var2) {
      return (Entity)(this.bean != null ? this.arc$delegate().update(var1, var2) : super.update(var1, var2));
   }

   @Override
   public List list(Page var1, Sort var2, String var3, Map var4) {
      return this.bean != null ? this.arc$delegate().list(var1, var2, var3, var4) : super.list(var1, var2, var3, var4);
   }

   @Override
   public int $$_page_count_add(Page var1) {
      return this.bean != null ? this.arc$delegate().$$_page_count_add(var1) : super.$$_page_count_add(var1);
   }

   public Entity add(Entity var1) {
      return (Entity)(this.bean != null ? this.arc$delegate().add(var1) : super.add(var1));
   }

   public List<Entity> list(Page var1, Sort var2) {
      return this.bean != null ? this.arc$delegate().list(var1, var2) : super.list(var1, var2);
   }

   public Entity get(ID var1) {
      return (Entity)(this.bean != null ? this.arc$delegate().get(var1) : super.get(var1));
   }

   public boolean delete(ID var1) {
      return this.bean != null ? this.arc$delegate().delete(var1) : super.delete(var1);
   }

   @Override
   public int $$_page_count_delete(Page var1) {
      return this.bean != null ? this.arc$delegate().$$_page_count_delete(var1) : super.$$_page_count_delete(var1);
   }

   @Override
   public int $$_page_count_get(Page var1) {
      return this.bean != null ? this.arc$delegate().$$_page_count_get(var1) : super.$$_page_count_get(var1);
   }
}
