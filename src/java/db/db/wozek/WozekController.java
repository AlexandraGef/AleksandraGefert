package db.db.wozek;

import db.db.wozek.util.JsfUtil;
import db.db.wozek.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;


@Named("wozekController")
@ViewScoped
public class WozekController implements Serializable {

    @EJB
    private db.db.wozek.WozekFacade ejbFacade;
    private List<Wozek> items = null;
    private Wozek selected;
    
    public void refresh()
    {
    }

    public void createwozek(Produkty selected,Integer ilosc){
      HttpSession session = SessionBean.getSession();
        Wozek wozek = new Wozek();
        wozek.setIlosc(ilosc);
        wozek.setKlient(session.getAttribute("uzytkownik").toString());
        wozek.setProduktKod(selected.getProduktKod());
        wozek.setProduktWartosc(selected.getProduktWartosc());
        wozek.setWozekData(new Date());
        this.getFacade().create(wozek);
           FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Dodano wybrany produkt do wózka",  "Dodano produkt do wózka ") );
}
   
     
    public WozekController() {
    }

    public Wozek getSelected() {
        return selected;
    }

    public void setSelected(Wozek selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private WozekFacade getFacade() {
        return ejbFacade;
    }

    public Wozek prepareCreate() {
        selected = new Wozek();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("WozekCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("WozekUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("WozekDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Wozek> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    public List<Wozek> getItemsbyklient(){
         HttpSession session = SessionBean.getSession();
        if (items == null) {
            items = getFacade().findq("select c from Wozek c where c.klient=:klient", "klient", session.getAttribute("uzytkownik").toString() );
        }
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

    public Wozek getWozek(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Wozek> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Wozek> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Wozek.class)
    public static class WozekControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            WozekController controller = (WozekController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "wozekController");
            return controller.getWozek(getKey(value));
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
            if (object instanceof Wozek) {
                Wozek o = (Wozek) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Wozek.class.getName()});
                return null;
            }
        }

    }

}
