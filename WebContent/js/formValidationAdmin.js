$(document).ready(function() {
	
 $("input[type=text],input[type=number], textarea").focus(function () {
      $(this).css("background", "rgba(128, 158, 173, 0.23)");
  });
 
 $("input[type=text],input[type=number], textarea").blur(function () {
     $(this).css("background", "white");
 });
});


function validaInserimentoProdotto()
{
	const nomeProdotto = document.getElementById("nomeProd");
	const descrizioneProdotto = document.getElementById("descrProd")
	const prezzoProdotto = document.getElementById("prezzoProd");
	const quantitaDisp = document.getElementById("qtaDisp");
	const ivaProd = document.getElementById("ivaProd");
	const coloreProd = document.getElementById("colore"); 
	const dimProd = document.getElementById("dimensione");
	const fotoProd = document.getElementById("foto"); 
	
	let nomeProdottoValue = nomeProdotto.value;
	let descrizioneProdottoValue = descrizioneProdotto.value;
	let prezzoProdottoValue = prezzoProdotto.value;
	let  quantitaDispValue = quantitaDisp.value;
	let ivaProdValue = ivaProd.value;
	let coloreProdValue = coloreProd.value;
	let dimProdValue = dimProd.value;
	let fotoProdValue = fotoProd.value;
	
	let nomeValido= false;
	let descrValida= false;
	let prezzoValido= false;
	let qtaValida= false;
	let ivaValida = false;
	let coloreValido= false;
	let dimValida= false;
	let fotoValida = false;
	
	if(nomeProdottoValue === "")
	{
		settaErrorePer(nomeProdotto, "Il campo nome prodotto non puo essere vuoto!");
	}
	else
	{
		nomeValido = true;
		settaSuccesso(nomeProdotto);
	}

	if(descrizioneProdottoValue === "")
	{

		settaErrorePer(descrizioneProdotto, "Il campo descrizione non puo essere vuoto!");
	}
	else
	{
		descrValida = true;
		settaSuccesso(descrizioneProdotto);
	}
	
	
	if( prezzoProdottoValue === "")
	{
		settaErrorePer(prezzoProdotto, "Il campo prezzo non puo essere vuoto!");
	}
	else if( prezzoProdottoValue <= 0)
	{
		settaErrorePer(prezzoProdotto, "Il prezzo non puo essere minore o uguale di 0");
	}
	else if(!isDoubleInCorrectFormat( prezzoProdottoValue))
	{
		settaErrorePer(prezzoProdotto, "Formato del prezzo non valido!!");
	}
	else
	{
		prezzoValido = true;
		settaSuccesso(prezzoProdotto);
	}
	
	
	if( quantitaDispValue === "")
	{
		settaErrorePer(quantitaDisp, "Il campo quantita non puo essere vuoto!");
	}
	else if( quantitaDispValue < 0)
	{
		settaErrorePer(quantitaDisp, "La quantita non puo essere minore di 0");
	}
	else if(!isANumber( quantitaDispValue))
	{
		settaErrorePer(quantitaDisp, "La quantita deve essere un valore numerico!");
	}
	else
	{
		qtaValida = true;
		settaSuccesso(quantitaDisp);
	}
	
	if( ivaProdValue === "")
	{
		settaErrorePer(ivaProd, "Il campo iva non puo essere vuoto!");
	}
	else if( ivaProdValue < 0)
	{
		settaErrorePer(ivaProd, "L'iva non puo essere minore di 0");
	}
	else if(!isDoubleInCorrectFormat(ivaProdValue))
	{
		settaErrorePer(ivaProd, "Formato iva non valido");
	}
	else
	{
		ivaValida = true;
		settaSuccesso(ivaProd);
	}
	
	if(coloreProdValue === "")
	{
		settaErrorePer(coloreProd, "Il campo colore non puo essere vuoto!");
	}
	else if( !isAColor(coloreProdValue))
	{
		settaErrorePer(coloreProd, "Il colore puo contenere solo lettere");
	}
	else
	{
		coloreValido = true;
		settaSuccesso(coloreProd);
	}
	
	if(dimProdValue === "")
	{
		settaErrorePer(dimProd, "Il campo dimensione non puo essere vuoto!");
	}
	else
	{
		dimValida = true;
		settaSuccesso(dimProd);
	}

	
	 let idxDot = fotoProdValue.lastIndexOf(".") + 1;
	 let extFile = fotoProdValue.substr(idxDot, fotoProdValue.length).toLowerCase();
	if(fotoProdValue === "")
	{
		settaErrorePer(fotoProd, "Il campo foto non puo essere vuoto!");
	}
	else if( (extFile !=="jpg" && extFile !=="jpeg" && extFile !=="png"))
	{
		settaErrorePer(fotoProd, "I formati consentitit sono jpg,jpeg e png!");
	}
	else
	{
		fotoValida = true;
		settaSuccesso(fotoProd);
	}
	
	
	if( ( nomeValido && descrValida && prezzoValido && qtaValida && ivaValida && coloreValido && dimValida && fotoValida) )
	{
		return true;
	}
	else
	{
		return false;
	}
	
}

function validaModificaProdotto()
{
	const nomeProdotto = document.getElementById("nomeProd");
	const descrizioneProdotto = document.getElementById("descrProd")
	const prezzoProdotto = document.getElementById("prezzoProd");
	const quantitaDisp = document.getElementById("qtaDisp");
	const ivaProd = document.getElementById("ivaProd");
	const coloreProd = document.getElementById("colore"); 
	const dimProd = document.getElementById("dimensione");
	
	let nomeProdottoValue = nomeProdotto.value;
	let descrizioneProdottoValue = descrizioneProdotto.value;
	let prezzoProdottoValue = prezzoProdotto.value;
	let  quantitaDispValue = quantitaDisp.value;
	let ivaProdValue = ivaProd.value;
	let coloreProdValue = coloreProd.value;
	let dimProdValue = dimProd.value;
	
	let nomeValido= false;
	let descrValida= false;
	let prezzoValido= false;
	let qtaValida= false;
	let ivaValida = false;
	let coloreValido= false;
	let dimValida= false;
	
	
	if(nomeProdottoValue === "")
	{
		settaErrorePer(nomeProdotto, "Il campo nome prodotto non puo essere vuoto!");
	}
	else
	{
		nomeValido = true;
		settaSuccesso(nomeProdotto);
	}

	if(descrizioneProdottoValue === "")
	{

		settaErrorePer(descrizioneProdotto, "Il campo descrizione non puo essere vuoto!");
	}
	else
	{
		descrValida = true;
		settaSuccesso(descrizioneProdotto);
	}
	
	
	if( prezzoProdottoValue === "")
	{
		settaErrorePer(prezzoProdotto, "Il campo prezzo non puo essere vuoto!");
	}
	else if( prezzoProdottoValue <= 0)
	{
		settaErrorePer(prezzoProdotto, "Il prezzo non puo essere minore o uguale di 0");
	}
	else if(!isDoubleInCorrectFormat( prezzoProdottoValue))
	{
		settaErrorePer(prezzoProdotto, "Formato del prezzo non valido!!");
	}
	else
	{
		prezzoValido = true;
		settaSuccesso(prezzoProdotto);
	}
	
	
	if( quantitaDispValue === "")
	{
		settaErrorePer(quantitaDisp, "Il campo quantita non puo essere vuoto!");
	}
	else if( quantitaDispValue < 0)
	{
		settaErrorePer(quantitaDisp, "La quantita non puo essere minore di 0");
	}
	else if(!isANumber( quantitaDispValue))
	{
		settaErrorePer(quantitaDisp, "La quantita deve essere un valore numerico!");
	}
	else
	{
		qtaValida = true;
		settaSuccesso(quantitaDisp);
	}
	
	if( ivaProdValue === "")
	{
		settaErrorePer(ivaProd, "Il campo iva non puo essere vuoto!");
	}
	else if( ivaProdValue < 0)
	{
		settaErrorePer(ivaProd, "L'iva non puo essere minore di 0");
	}
	else if(!isDoubleInCorrectFormat(ivaProdValue))
	{
		settaErrorePer(ivaProd, "Formato iva non valido");
	}
	else
	{
		ivaValida = true;
		settaSuccesso(ivaProd);
	}
	
	if(coloreProdValue === "")
	{
		settaErrorePer(coloreProd, "Il campo colore non puo essere vuoto!");
	}
	else if( !isAColor(coloreProdValue))
	{
		settaErrorePer(coloreProd, "Il colore puo contenere solo lettere");
	}
	else
	{
		coloreValido = true;
		settaSuccesso(coloreProd);
	}
	
	if(dimProdValue === "")
	{
		settaErrorePer(dimProd, "Il campo dimensione non puo essere vuoto!");
	}
	else
	{
		dimValida = true;
		settaSuccesso(dimProd);
	}

	
	
	if( ( nomeValido && descrValida && prezzoValido && qtaValida && ivaValida && coloreValido && dimValida) )
	{
		return true;
	}
	else
	{
		return false;
	}
	
}

function validaModificaFoto()
{
	const fotoProd = document.getElementById("foto"); 
	let fotoProdValue = fotoProd.value;
	let fotoValida = false;
	

	 let idxDot = fotoProdValue.lastIndexOf(".") + 1;
	 let extFile = fotoProdValue.substr(idxDot, fotoProdValue.length).toLowerCase();
	if(fotoProdValue === "")
	{
		settaErrorePer(fotoProd, "Il campo foto non puo essere vuoto!");
	}
	else if( (extFile !=="jpg" && extFile !=="jpeg" && extFile !=="png"))
	{
		settaErrorePer(fotoProd, "I formati consentitit sono jpg,jpeg e png!");
	}
	else
	{
		fotoValida = true;
		settaSuccesso(fotoProd);
	}
	
	
	if( fotoValida)
	{
		return true;
	}
	else
	{
		return false;
	}



}


function isDoubleInCorrectFormat( value)
{	
	return /^(?!0*\.0+$)\d*(?:\.\d+)?$/.test(value);
}

function isANumber( value)
{
	return /^[0-9]*$/.test(value);
}

function isAColor( value)
{
	return /^[a-zA-Z\s]*$/.test(value);
}



//Setta l'errore all'input sbagliato, con il dovuto messaggio di errore
function settaSuccesso(input)
{
	let formGroup = input.parentElement; //prendo form-group
	console.log(formGroup);
	
	//Aggiorno la classe del form-group
	formGroup.className = "form-group success";

}

//Setta l'errore all'input sbagliato, con il dovuto messaggio di errore
function settaErrorePer(input, messaggio)
{
	let formGroup = input.parentElement; //prendo form-group
	console.log(formGroup);
	let small = formGroup.querySelector("small"); //prendo lo small del form group
	
	//Aggiungo il messaggio d'errore
	small.innerText = messaggio;
	
	//Aggiorno la classe del form-group
	formGroup.className = "form-group error";
}
