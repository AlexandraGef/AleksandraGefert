/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.db.wozek;

/**
 *
 * @author Ola
 */
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import sun.security.util.Debug;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@SessionScoped
@Named("commonbean")
public class commonbean implements Serializable {

    private String css;
    @Inject
    private MenuController mc;
    @EJB
    private db.db.wozek.UzytkownikFacade ejbFacadeusernm;
    private Integer ilosc;
    private String platnosc;

    public String getPlatnosc() {
        return platnosc;
    }

    public void setPlatnosc(String platnosc) {
        this.platnosc = platnosc;
    }

    public Integer getIlosc() {
        return ilosc;
    }

    public void setIlosc(Integer ilosc) {
        this.ilosc = ilosc;
    }

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public void setsessilosc(String var, Integer data) {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
        if (var.equals("sessionilosc")) {
            session.setAttribute("sessionilosc", data);
        }
    }

    public Integer getsessilosc(String var) {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
        if (var.equals("sessionilosc")) {
            if (session.getAttribute("sessionilosc") != null) {
                return (Integer) session.getAttribute("sessionilosc");
            }
        }
        return null;
    }

    public void setsess(String var, String data) {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
        if (var.equals("sessioncss")) {
            session.setAttribute("sessioncss", data);
        }
        if (var.equals("role")) {
            session.setAttribute("role", data);
        }
        if (var.equals("sessioncatg")) {
            session.setAttribute("sessioncatg", data);
        }
        if (var.equals("sessionsort")) {
            session.setAttribute("sessionsort", data);
        }
        if (var.equals("sessionsortorder")) {
            session.setAttribute("sessionsortorder", data);
        }
        if (var.equals("sessionuser")) {
            session.setAttribute("sessionuser", data);
        }
        if (var.equals("sessionplatnosc")) {
            session.setAttribute("sessionplatnosc", data);
        }
    }

    public String getsess(String var) {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
        if (var.equals("sessioncss")) {
            if (session.getAttribute("sessioncss") != null) {
                return session.getAttribute("sessioncss").toString();
            }
        }
        if (var.equals("role")) {
            if (session.getAttribute("role") != null) {
                return session.getAttribute("role").toString();
            }
        }
        if (var.equals("sessionuser")) {
            if (session.getAttribute("sessionuser") != null) {
                return session.getAttribute("sessionuser").toString();
            }
        }
        if (var.equals("sessioncatg")) {
            if (session.getAttribute("sessioncatg") != null) {
                return session.getAttribute("sessioncatg").toString();
            }
        }
        if (var.equals("sessionsort")) {
            if (session.getAttribute("sessionsort") != null) {
                return session.getAttribute("sessionsort").toString();
            }
        }
        if (var.equals("sessionsortorder")) {
            if (session.getAttribute("sessionsortorder") != null) {
                return session.getAttribute("sessionsortorder").toString();
            }

        }
        if (var.equals("sessionplatnosc")) {
            if (session.getAttribute("sessionplatnosc") != null) {
                return session.getAttribute("sessionplatnosc").toString();
            }
        }
        return "";
    }

    public void login(Uzytkownik selected) {
        FacesMessage message = null;
        boolean loggedIn = false;

        RequestContext context = RequestContext.getCurrentInstance();
        String qry = "select c from Uzytkownik c where c.user=:user and c.password=:password ";
        List<Uzytkownik> uzytkownik = ejbFacadeusernm.findq(qry, "user", selected.getUser(),
                "password", selected.getPassword());

        Debug.println(uzytkownik.size() + "", selected.getUser());
        if (uzytkownik.size() != 0) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Witamy " + selected.getUser(),
                    selected.getUser());
            new commonbean().setsess("sessionuser", uzytkownik.get(0).getUser());
            new commonbean().setsess("role", uzytkownik.get(0).getRole());
            //based on user name getched from database;
            login_cred(uzytkownik.get(0).getUser()); //set user session.
            role_cred(uzytkownik.get(0).getRole());
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Błąd logowania: nieprawidłowe hasło lub login",
                    "Invalid credentials");
            new commonbean().setsess("sessionuser", "not Logged");
        }
        //load new menu based on role
        mc.init();
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
    }

    public String logout() {

        FacesMessage message = null;
        HttpSession session = SessionBean.getSession();
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dziękujemy za wizytę " + session.getAttribute("uzytkownik"), " ");
        FacesContext.getCurrentInstance().addMessage(null, message);

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml?faces-redirect=true";

    }

    public void login_cred(String user) {
        HttpSession session = SessionBean.getSession();
        session.setAttribute("uzytkownik", user);
        Debug.println("session login", session.getAttribute("uzytkownik").toString());
    }

    public void role_cred(String role) {
        HttpSession session = SessionBean.getSession();
        session.setAttribute("role", role);
        Debug.println("session role", session.getAttribute("role").toString());
    }

    private boolean flag1;
    private boolean flag2;

    public boolean isFlag1() {
        return flag1;
    }

    public void setFlag1(boolean flag1) {
        this.flag1 = flag1;
    }

    public boolean isFlag2() {
        return flag2;
    }

    public void setFlag2(boolean flag2) {
        this.flag2 = flag2;
    }

    public void controlflag() {
        if (flag1 == true) {
            flag1 = false;
            flag2 = true;

        } else {
            flag2 = false;
            flag1 = true;
        }
    }
}
