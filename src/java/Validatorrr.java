import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ola
 */
@FacesValidator (value="Validatorrr")
public class Validatorrr implements Validator{
FacesMessage msg;
    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException 
    {
        if((String) o == null || ((String)o).isEmpty() || ((String) o).contains(" "))
                {
                   FacesMessage msg = new FacesMessage("Proszę uzupełnić dane","Walidacja się nie powiodła") ;
                   
                   msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                   throw new ValidatorException(msg);
                }
    }
    
}
