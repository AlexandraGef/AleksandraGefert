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

@Named("uzytkownikController")
@ViewScoped
public class UzytkownikController implements Serializable {

    @EJB
    private db.db.wozek.UzytkownikFacade ejbFacade;
    private MenuController mc;
    private List<Uzytkownik> items = null;
    private Uzytkownik selected;

    public UzytkownikController() {
    }

    public List<Uzytkownik> getItemsbyklient() {
        HttpSession session = SessionBean.getSession();
        if (items == null) {
            items = getFacade().findq("select c from Uzytkownik c where c.user=:user", "user", session.getAttribute("uzytkownik").toString());
        }
        return items;
    }

    public Uzytkownik getSelected() {
        return selected;
    }

    public void setSelected(Uzytkownik selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private UzytkownikFacade getFacade() {
        return ejbFacade;
    }

    public Uzytkownik prepareCreate() {
        selected = new Uzytkownik();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("UzytkownikCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void login_validate() {
        String user = selected.getUser();
        Date dob = selected.getDob();


        List<Uzytkownik> uzytkownik = this.ejbFacade.findq("select c from Uzytkownik c where c.user=:user", "user", user);

        if (uzytkownik.size() == 0) {
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Błąd logowania", "Nieprawidłowe uwierzytelnienie");

            FacesContext.getCurrentInstance().addMessage(null, message);
        } else 
            selected = uzytkownik.get(0);
      
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("UzytkownikUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("UzytkownikDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Uzytkownik> getItems() {
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

    public Uzytkownik getUzytkownik(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Uzytkownik> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Uzytkownik> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Uzytkownik.class)
    public static class UzytkownikControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UzytkownikController controller = (UzytkownikController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "uzytkownikController");
            return controller.getUzytkownik(getKey(value));
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
            if (object instanceof Uzytkownik) {
                Uzytkownik o = (Uzytkownik) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Uzytkownik.class.getName()});
                return null;
            }
        }

    }

}
