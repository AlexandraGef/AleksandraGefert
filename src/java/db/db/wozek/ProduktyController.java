package db.db.wozek;

import db.db.wozek.util.JsfUtil;
import db.db.wozek.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sun.security.ssl.Debug;

@Named("produktyController")
@SessionScoped
public class ProduktyController implements Serializable {

     @EJB
    private db.db.wozek.ProduktyFacade ejbFacade;
    private List<Produkty> items = null;
    private Produkty selected;
    private String sortitem;
    private String sortorder;
    private String sortcatg;

    public String getSortcatg() {
        return sortcatg;
    }

    public void setSortcatg(String sortcatg) {
        this.sortcatg = sortcatg;
    }

    public String getSortitem() {
        return sortitem;
    }

    public void setSortitem(String sortitem) {
        this.sortitem = sortitem;
    }

    public String getSortorder() {
        return sortorder;
    }

    public void setSortorder(String sortorder) {
        this.sortorder = sortorder;
    }

    public ProduktyController() {
    }

    public Produkty getSelected() {
        return selected;
    }

    public void setSelected(Produkty selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ProduktyFacade getFacade() {
        return ejbFacade;
    }

    public Produkty prepareCreate() {
        selected = new Produkty();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ProduktyCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ProduktyUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ProduktyDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

     public List<Produkty> getItems(){
        commonbean cb = new commonbean();
        if( items == null){
            items = getFacade().findAll();
        }
        else 
        {
            String sct = cb.getsess("sessioncatg");
            Debug.println("sct", sct);
            if (sct == "Wszystko" || sct == "") 
            items = getFacade().findAll();
            else 
            items=getFacade().findq("SELECT g FROM Produkty g WHERE g.produktKategoriaKodu=:produktKategoriaKodu","produktKategoriaKodu",sct);
        }
        String sct = cb.getsess("sessionsort");
        if(!sct.isEmpty()) items= getsortedItems();
      
        return items;
        
    }
    
    public List <Produkty> getsortedItems(){
        commonbean cb = new commonbean();
        String ord = cb.getsess("sessionsortorder");
        if(ord.isEmpty())ord="asc";
        items=getFacade().findqsort("SELECT i FROM Produkty i order by i."+cb.getsess("sessionsort")+" "+ord);
        return items;
    }

 
    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Produkty getProdukty(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Produkty> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Produkty> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Produkty.class)
    public static class ProduktyControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProduktyController controller = (ProduktyController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "produktyController");
            return controller.getProdukty(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Produkty) {
                Produkty o = (Produkty) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Produkty.class.getName()});
                return null;
            }
        }

    }
}
