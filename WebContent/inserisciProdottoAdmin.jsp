<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="it.unisa.model.beans.Prodotto, it.unisa.model.beans.Utente" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Inserisci prodotto</title>
</head>
<body>

<!-- Modal -->
<div class="modal fade" id="aggiungiProdottoModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-md modal-lg" role="document">
	<div class="modal-content">
		<div class="modal-header">
		<h5 class="modal-title" id="exampleModalLabel">Aggiungi prodotto</h5>
		<button type="button" class="close" data-dismiss="modal" aria-label="Close">
			 <span aria-hidden="true">&times;</span>
		</button>
		</div>
		 <div class="modal-body">
		 
			 	<form id="addProdcut" action="aggiungiprodotto" onsubmit="return validaInserimentoProdotto();" enctype="multipart/form-data" method="POST">
				
				
				<div class="row">
				
				<div class="col-lg-6">
				<!--  Nome -->
				<div class="form-group">
				 <label> Nome prodotto:</label>
					<input type ="text" class="form-control" id="nomeProd" placeholder="Inserisci nome prodotto..." name="nomeProd"/>
					<small>Error message</small>
				</div>
				</div>
				
				<div class="col-lg-6">
					<!-- Foto -->
				<div class="form-group">
				 <label> Inserire foto prodotto:</label>
				 <input type="file" id="foto" class="form-control"  name="photo">
				 <small>Error message</small>
				</div>
				</div>
				
				</div>
				
				
				<!-- Descrizione -->
				<div class="form-group">
				 <label> Descrizione:</label>
					<textarea style="height: 100px; resize: none;" id="descrProd" class="form-control" placeholder="Inserisci descrizione..." name="descriz"></textarea>
					<small>Error message</small>
				</div>
				
				
				<div class="row">
				<div class="col-lg-6">
				<!-- Prezzo-->
				<div class="form-group">
				 <label> Prezzo prodotto: </label>
					<input type="text" id="prezzoProd" class="form-control" placeholder="Inserisci prezzo( Formato Esempio 10.90 o 10)" name="prezzoProd"/>
					<small>Error message</small>
				</div>
				
				</div>
				<div class="col-lg-6">
				<!-- Categoria-->
				<div class="form-group">
				 <label> Categoria:</label>
				 
					<select id="select-categoria" class="form-control" name="categoria">
					
					</select>
				</div>
				
				</div>			
				</div>
				
				
				<div class="row">
				<div class="col-lg-6">
					
				<!-- Quantita-->
				<div class="form-group">
				 <label> Quantita disponibile:</label>
					<input type="number" id="qtaDisp" class="form-control" placeholder="Inserisci quantita disponibile" name="qtaDisp"/>
					<small>Error message</small>
				</div>
				
				</div>
				<div class="col-lg-6">
				<!--IVA-->
				<div class="form-group">
				 <label> Iva:</label>
					<input type="number" id="ivaProd" class="form-control" placeholder="Inserisci iva" name="ivaProd"/>
					<small>Error message</small>
				</div>
				
				</div>
				</div>
				
				<div class="row">
				<div class="col-lg-6">
					
				<!-- Quantita-->
				<div class="form-group">
				 <label> Colore:</label>
					<input type="text" id="colore" class="form-control" placeholder="Inserisci colore.." name="colore"/>
					<small>Error message</small>
				</div>
				
				</div>
				<div class="col-lg-6">
				<!--IVA-->
				<div class="form-group">
				 <label> Dimensione:</label>
					<input type="text" id="dimensione" class="form-control" placeholder="Inserisci dimensione.." name="dimensione"/>
					<small>Error message</small>
				</div>
				
				</div>
				</div>
				
		
				<div class="container text-center">
						<input type="submit"  class="btn btn-primary" value="Aggiungi"/> 
					</div>
			</form>
		 </div>
		</div>
	</div>
	</div>
</body>
<script src="js/formValidationAdmin.js"></script>
<script src="js/formCategoria.js"></script>
</html>