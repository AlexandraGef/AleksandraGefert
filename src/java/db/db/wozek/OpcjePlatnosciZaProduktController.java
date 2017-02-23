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

@Named("opcjePlatnosciZaProduktController")
@SessionScoped
public class OpcjePlatnosciZaProduktController implements Serializable {

    @EJB
    private db.db.wozek.OpcjePlatnosciZaProduktFacade ejbFacade;
    private List<OpcjePlatnosciZaProdukt> items = null;
    private OpcjePlatnosciZaProdukt selected;

    public OpcjePlatnosciZaProduktController() {
    }

    public OpcjePlatnosciZaProdukt getSelected() {
        return selected;
    }

    public void setSelected(OpcjePlatnosciZaProdukt selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private OpcjePlatnosciZaProduktFacade getFacade() {
        return ejbFacade;
    }

    public OpcjePlatnosciZaProdukt prepareCreate() {
        selected = new OpcjePlatnosciZaProdukt();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("OpcjePlatnosciZaProduktCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("OpcjePlatnosciZaProduktUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("OpcjePlatnosciZaProduktDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<OpcjePlatnosciZaProdukt> getItems() {
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

    public OpcjePlatnosciZaProdukt getOpcjePlatnosciZaProdukt(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<OpcjePlatnosciZaProdukt> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<OpcjePlatnosciZaProdukt> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = OpcjePlatnosciZaProdukt.class)
    public static class OpcjePlatnosciZaProduktControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            OpcjePlatnosciZaProduktController controller = (OpcjePlatnosciZaProduktController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "opcjePlatnosciZaProduktController");
            return controller.getOpcjePlatnosciZaProdukt(getKey(value));
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
            if (object instanceof OpcjePlatnosciZaProdukt) {
                OpcjePlatnosciZaProdukt o = (OpcjePlatnosciZaProdukt) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), OpcjePlatnosciZaProdukt.class.getName()});
                return null;
            }
        }

    }

}
