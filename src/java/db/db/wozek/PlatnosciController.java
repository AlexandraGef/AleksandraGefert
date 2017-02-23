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
import javax.servlet.http.HttpSession;

@Named("platnosciController")
@SessionScoped
public class PlatnosciController implements Serializable {

    @EJB
    private db.db.wozek.PlatnosciFacade ejbFacade;
    private List<Platnosci> items = null;
    private Platnosci selected;


    
     public void createwozek(String kodprod,String platnosc){
      HttpSession session = SessionBean.getSession();
        Platnosci platnosci = new Platnosci();
        platnosci.setKlient(session.getAttribute("uzytkownik").toString());
        platnosci.setPlatnosciData(new Date());
        platnosci.setPlatnosciOpcje(platnosc);
        platnosci.setPlatnosciStatus("Oczekuje");
        platnosci.setProduktKod(kodprod);
        platnosci.setUserkod(session.getAttribute("uzytkownik").toString());
        this.getFacade().create(platnosci);
        
        

        
        
           FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Dziękujemy za zakup !",  "Dodano produkt do wózka ") );
}
    public PlatnosciController() {
    }

    public Platnosci getSelected() {
        return selected;
    }

    public void setSelected(Platnosci selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private PlatnosciFacade getFacade() {
        return ejbFacade;
    }

    public Platnosci prepareCreate() {
        selected = new Platnosci();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("PlatnosciCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PlatnosciUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PlatnosciDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Platnosci> getItems() {
        if (items == null) {
            items = getFacade().findAll();
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

    public Platnosci getPlatnosci(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Platnosci> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Platnosci> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Platnosci.class)
    public static class PlatnosciControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PlatnosciController controller = (PlatnosciController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "platnosciController");
            return controller.getPlatnosci(getKey(value));
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
            if (object instanceof Platnosci) {
                Platnosci o = (Platnosci) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Platnosci.class.getName()});
                return null;
            }
        }

    }

}
