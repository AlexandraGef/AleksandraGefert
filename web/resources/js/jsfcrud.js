function handleSubmit(args, dialog) {
    var jqDialog = jQuery('#' + dialog);
    if (args.validationFailed) {
        jqDialog.effect('shake', {times: 3}, 100);
    } else {
        PF(dialog).hide();
    }
}
    function fvalidate(para1,para2)
    {
        var pass1 = document.getElementById(para1);
        var pass2 = document.getElementById(para2);
        if(pass1.value == pass2.value)
        {
            return true;
        }
        else
            document.getElementById(String para1).focus();
        alert("Hasła sa różne");
        return false;
        }
        function scrolldiv()
        {
            //scroller.scrollLeft = 0;
            ni= setInterval(scroll, 50);
        }
        function scroll()
        {
            if(scroller.scrollLeft < 500)
                scroller.scrollLeft +=1;
            else
                scroller.scrollLeft = 0;
        }
        function capitalize_name(textboxid)
        {
            str = textboxid.value;
            
            var fword = str.split(" ");
            var fsentence="";
            for (i=0; i<fword.length; i++){
                cword = capitalize(fword[i]);
            if(i == 0)
                fsentence = cword;
            else
                fsentence= fsentence.trim()+" "+ cword; }
            textboxid.value = fsentence;
            allLetterandspace(textboxid);
        }
      
        function capitalize(str)
        {
            if(str && str.length >= 1)
            {
                var firstChar = str.charAt(0);
                var remainingStr = str.slice(1);
                str = firstChar.toUpperCase() + remainingStr;
            }
            return str;
                
            }
function userid_validation(uid, mx, my, ttype)
{
    var uid_len = uid.value.length;
    if (uid_len == 0 || uid_len >= my || uid_len < mx)
    {
        fnmsg("Nazwa użytkownika nie może być pusta/ długość od " + mx + "do" + my);
        uid.focus();
        return false;
    }
    
    if(ttype == "letter") 
        allLetter(uid);
    return true;
}

function allLetter(uname)
{
    var letters = /^[A-Za-z] +$/;
    if (uname.value.match(letters))
    {
        return true;
    }else
    {
        alert('Tylko litery alfabetu');
        uname.focus();
        return false;
    }
}

