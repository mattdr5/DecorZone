$(document).ready(function() {
	
 $("input[type=text],input[type=password]").focusin(function () {
      $(this).css("background", "rgba(128, 158, 173, 0.23)");
  });
 
 $("input[type=text],input[type=password]").focusout(function () {
     $(this).css("background", "white");
 });
});


function validaRegistrazione()
{
	const nomeInput = document.getElementById("nome");
	const cognomeInput = document.getElementById("cognome")
	const emailInput = document.getElementById("email");
	const passwordInput = document.getElementById("password");
	const numTelInput = document.getElementById("numTel"); 
	
	let nomeValue= nomeInput.value;
	let cognomeValue= cognomeInput.value;
	let emailValue=emailInput.value.trim();
	let passwordValue=passwordInput.value.trim();
	let numTelValue = numTelInput.value;
	
	let nomeValido= false;
	let cognomeValido= false;
	let emailValida= false;
	let passwordValida= false;
	let numTelValido = false;
	
	if(nomeValue === "")
	{
		settaErrorePer(nomeInput, "Il campo nome non puo essere vuoto!");
	}
	else if(!isAName(nomeValue))
	{
		settaErrorePer(nomeInput, "Il campo nome non puo contenere caratteri speciali o numeri!");
	}
	else
	{
		nomeValido = true;
		settaSuccesso(nomeInput);
	}
	
	if(cognomeValue === "")
	{
	
		settaErrorePer(cognomeInput, "Il campo cognome non puo essere vuoto!");
	}
	else if(!isACognome(cognomeValue))
	{
		settaErrorePer(cognomeInput, "Il campo cognome non puo contenere caratteri speciali o numeri!");
	}
	else
	{
		cognomeValido = true;
		settaSuccesso(cognomeInput);
	}
	
	if(emailValue === "")
	{
		settaErrorePer(emailInput, "Il campo email non puo essere vuoto!");
	}
	else if(!isEmail(emailValue))
	{
		settaErrorePer(emailInput, "L'email non e\' valida!");
	}	
	else if(checkEmail(emailValue))
	{
		settaErrorePer(emailInput, "L'email e\' gia in uso!");
	}
	else
	{
		emailValida = true;
		settaSuccesso(emailInput);
	}
	
	if(passwordValue === "")
	{
		settaErrorePer(passwordInput, "Il campo password non puo essere vuoto!");
	}
	else if(!isPassword(passwordValue))
	{
		settaErrorePer(passwordInput, "La password deve essere almeno di 8 caratteri");
	}
	else
	{
		passwordValida = true;
		settaSuccesso(passwordInput);
	}
	if(numTelValue === "")
	{
		settaErrorePer(numTelInput, "Il numero di telefono non puo essere vuoto!");
	}
	else if(!isNumeroTelefono(numTelValue))
	{
		settaErrorePer(numTelInput, "Numero di telefono non valido!");
	}
	else
	{
		numTelValido = true;
		settaSuccesso(numTelInput);
	}
	
	
	
	
	if( (nomeValido && cognomeValido && emailValida && passwordValida && numTelValido ))
	{
		return true;
	}
	else
	{
		return false;
	}
	
}





function validaCheckout()
{
	const numTelCheckout = document.getElementById("numTelCheckout");
	const indirizzo = document.getElementById("indirizzo");
	const cap = document.getElementById("cap");
	const citta = document.getElementById("citta"); 
	const numeroCarta = document.getElementById("numCarta");
	
	let numTelCheckoutValue= numTelCheckout.value;
	let indirizzoValue= indirizzo.value;
	let capValue= cap.value.trim();
	let cittaValue= citta.value;
	let numCartaValue = numeroCarta.value;

	let numTelCheckoutValido= false;
	let indirizzoValido= false;
	let capValido= false;
	let cittaValida= false;
	let numCartaValida = false;

	if(indirizzoValue === "")
	{
		settaErrorePer(indirizzo, "Il campo indirizzo non puo essere vuoto!");
	}
	else
	{
		indirizzoValido = true;
		settaSuccesso(indirizzo);
	}

	if(capValue === "")
	{

		settaErrorePer(cap, "Il campo CAP non puo essere vuoto!");
	}
  else if(capValue < 0 )
  {
    settaErrorePer(cap, "Il campo CAP non puo avere numeri negativi!");
  }
	else if(!isACAP(capValue))
	{
		settaErrorePer(cap, "Il campo CAP deve contenere 5 numeri!");
	}
	else
	{
		capValido = true;
		settaSuccesso(cap);
	}

	if(cittaValue=== "")
	{
		settaErrorePer(citta, "Il campo citta non puo essere vuoto!");
	}
	else
	{
		cittaValida = true;
		settaSuccesso(citta);
	}

	if(numTelCheckoutValue === "")
	{
		settaErrorePer(numTelCheckout, "Il numero di telefono non puo essere vuoto!");
	}
	else if(!isNumeroTelefono(numTelCheckoutValue))
	{
		settaErrorePer(numTelCheckout, "Numero di telefono non valido!");
	}
	else
	{
		numTelCheckoutValido = true;
		settaSuccesso(numTelCheckout);
	}
	if(numCartaValue == "")
	{
		settaErrorePer(numCarta, "il campo numero carta non puo essere vuoto!");
	}
	else if(!isNumCarta(numCartaValue))
	{
		settaErrorePer(numCarta, "Il numero carta deve avere 16 numeri!");
	}
	else if(!checkCarta(numCartaValue))
	{
		settaErrorePer(numCarta, "Numero carta non esistente!");
	}
	else
	{
		numCartaValida = true;
		settaSuccesso(numCarta);
	}


	if( (indirizzoValido && capValido && cittaValida && numTelCheckoutValido && numCartaValida))
	{
		return true;
	}
	else
	{
		return false;
	}
}


function validaLogin()
{ 
	const emailLogin = document.getElementById("emailLogin");
	const passwordLogin = document.getElementById("passwordLogin");
	
	let emailLoginValue = emailLogin.value;
	let passwordLoginValue= passwordLogin.value;
	
	let emailLoginValida = false;
	let passwordLoginValida = false;
	


	if(emailLoginValue === "")
	{
		settaErrorePer(emailLogin, "Il campo email non puo essere vuoto!");
	}
	else if(!isEmail(emailLoginValue))
	{
		settaErrorePer(emailLogin, "L'email non e\' valida!");
	}	
	else
	{
		emailLoginValida = true;
		settaSuccesso(emailLogin);
	}

	if(passwordLoginValue === "")
	{
		settaErrorePer(passwordLogin, "Il campo password non puo essere vuoto!");
	}
	else
	{
		passwordLoginValida = true;
		settaSuccesso(passwordLogin);
	}




	if( (emailLoginValida && passwordLoginValida) )
	{
		return true;
	}
	else
	{
		return false;
	}
	

}


function validaModificaDatiUtente()
{


	const nomeUser = document.getElementById("nomeUtente");
	const cognomeUser = document.getElementById("cognomeUtente");
	const numeroTelUser = document.getElementById("numTelUtente");
	
	let nomeUserValue = nomeUser.value;
	let cognomeUserValue = cognomeUser.value;
	let numeroTelUserValue = numeroTelUser.value;
	
	let nomeUserValido = false;
	let cognomeUserValido = false;
	let numTelUserValido = false;


	if(nomeUserValue === "")
	{
		settaErrorePer(nomeUser, "Il campo email non puo essere vuoto!");
	}
	else if(!isAName(nomeUserValue))
	{
		settaErrorePer(nomeUser,"Il campo nome non puo contenere caratteri speciali o numeri!");
	}
	else
	{
		nomeUserValido = true;
		settaSuccesso(nomeUser);
	}

	if(cognomeUserValue === "")
	{

		settaErrorePer(cognomeUser, "Il campo cognome non puo essere vuoto!");
	}
	else if(!isACognome(cognomeUserValue))
	{
		settaErrorePer(cognomeUser, "Il campo cognome non puo contenere caratteri speciali o numeri!");
	}
	else
	{
		cognomeUserValido = true;
		settaSuccesso(cognomeUser);
	}
	
	if( numeroTelUserValue === "")
	{
		settaErrorePer(numeroTelUser, "Il numero di telefono non puo essere vuoto!");
	}
	else if(!isNumeroTelefono( numeroTelUserValue))
	{
		settaErrorePer(numeroTelUser, "Numero di telefono non valido!");
	}
	else
	{
		numTelUserValido = true;
		settaSuccesso(numeroTelUser);
	}


	if( (nomeUserValido && numTelUserValido && cognomeUserValido) )
	{
		return true;
	}
	else
	{
		return false;
	}
	

}


function validaModificaPasswordUtente()
{
	const password1 = document.getElementById("passwordUtente1");
	
	let passwordValue1= password1.value;


	let passwordValida1= false;

	// If password not entered 
    if (passwordValue1 === "") 
    {
    	settaErrorePer(password1, "Il campo password non puo essere vuoto!");
    }
    else if(!isPassword(passwordValue1))
	{
		settaErrorePer(password1, "La password deve essere almeno di 8 caratteri");
	}
    else
    {
    	passwordValida1 = true;
    	settaSuccesso(password1);

    }
    
    
	if( (passwordValida1) )
	{
		return true;
	}
	else
	{
		return false;
	}
    
}
 


//Setta l'errore all'input sbagliato, con il dovuto messaggio di errore
function settaSuccesso(input)
{
	let formGroup = input.parentElement; //prendo form-group
	
	//Aggiorno la classe del form-group
	formGroup.className = "form-group success";

}

//Setta l'errore all'input sbagliato, con il dovuto messaggio di errore
function settaErrorePer(input, messaggio)
{
	let formGroup = input.parentElement; //prendo form-group
	let small = formGroup.querySelector("small"); //prendo lo small del form group
	
	//Aggiungo il messaggio d'errore
	small.innerText = messaggio;
	
	//Aggiorno la classe del form-group
	formGroup.className = "form-group error";
}


function isAName(nome){
	
	return /^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$/.test(nome);
}

function isACognome(cognome){
	
	return /^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$/.test(cognome);
}

function isPassword(password){
	return /^.{8}/.test(password);
}

function isEmail(email){
	return /^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/.test(email);
}

function isNumeroTelefono(numTel)
{
	return /^((00|\+)39[\. ]??)??3\d{2}[\. ]??\d{6,7}$/.test(numTel);
}

function isNumCarta(num){
	return /^.{16}/.test(num);
}

function checkEmail(email)
{
	let trovato = false;
	
	
	// uso ajax per verificare se un utente con quell'email è gia registrato
    // uso l'email
	$.ajax({
        type: "POST",
        url: "validaemail",
        async: false,
        dataType: "text",
        data: {"email" : email},
        success: function (response) {
            if(response === "presente")
            {
            	trovato = true; //l'email è gia presente
            }
        }
        
    });
	
	if(!trovato) 
	{ //gestione valore di ritorno
        
        return false;
   } 
   else 
   { 
	   return true; 
   }
	
}


function checkCarta(numCarta)
{
let trovato = false;
	
	// uso ajax per verificare se una carta con quel numero esiste
	$.ajax({
        type: "POST",
        url: "validacarta",
        async: false,
        dataType: "text",
        data: {"numCarta" : numCarta},
        success: function (response) {
            if(response === "presente")
            {
            	trovato = true; //num carta presente
            }
        }
        
    });
	
	if(!trovato) 
	{ //gestione valore di ritorno
        
        return false;
   } 
   else 
   { 
	   return true; 
   }

}

function isACAP(capValue)
{
	return /^\d{5}$/.test(capValue);

}


