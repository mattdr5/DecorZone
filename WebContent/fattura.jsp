<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
import="it.unisa.model.beans.DettaglioOrdine, it.unisa.model.beans.Ordine, it.unisa.model.beans.Utente, java.util.ArrayList ,java.time.LocalDateTime"
    pageEncoding="ISO-8859-1"%>
      <% ArrayList<DettaglioOrdine> dettaglio = (ArrayList<DettaglioOrdine>) request.getAttribute("prodotti");
    	Ordine ordine = (Ordine) request.getAttribute("ordine");
    	Utente utente = (Utente) request.getAttribute("user");
if(dettaglio == null || ordine == null)
{
	response.sendError(404);
}else
{

%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="imgs/logo/sofa.svg"> <!-- mini logo -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style1.css">
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Fattura</title>
</head>
<body>

<div class="page-wrap d-flex flex-flex align-items-center">

 <div class="offset-xl-2 col-xl-8 col-lg-12 col-md-12 col-sm-12 col-12 padding">
     <div class="card">
    <div id="myheader">
	<div class="mycontainer-header">
        
         <div class="mylogo">
            <h3 id="my-text-logo-fattura"> DecorZone</h3>
            </div>         
         <div class="card-header p-4">
        
             <div class="float-right fatt-ord">
                 <h3>Fattura Ordine# <%= ordine.getIdOrdine() %></h3>
                 Data: <%= ordine.getDataOrdine() %>
             </div>
         </div>
         </div>
         </div>
         <div class="card-body">
             <div class="row mb-4">
                 <div class="col-sm-6">
                     <h5 class="mb-3">Da:</h5>
                     <h3 class="text-dark mb-1">DecorZone</h3>
                     <div>Italia ,Salerno , zona fittizia </div>
                     <div>via sconosciuta ,25</div>
                     <div>Email: decorzone@gmail.com</div>
                     <div>Telefono: 800.97.09.09 </div>
                 </div>
                 <div class="col-sm-6 ">
                     <h5 class="mb-3">A:</h5>
                     <h3 class="text-dark mb-1"><%=utente.getNomeUtente()+" "+utente.getCognomeUtente() %></h3>
                     <div><%=ordine.getIndirizzoSpedizione() %></div>
                     <div>Email: <%=utente.getEmailUtente() %></div>
                 </div>
             </div>
             <div class="table-responsive-sm">
                 <table class="table table-striped">
                     <thead>
                         <tr>
                             <th>Prodotto</th>
                             <th class="right">Prezzo Unitario</th>
                             <th class="center">Qnt</th>
                             <th class="center">IVA</th>
                             <th class="right">Totale</th>
                         </tr>
                     </thead>
                      <% for(DettaglioOrdine prodotto : dettaglio )
       					 {
       				  %>
                     <tbody>
                         <tr>
                             <td class="left strong"><%=prodotto.getProdottoAssociato().getNomeProdotto() %></td>
                             <td class="right"><%=String.format("%.2f", prodotto.getPrezzoUnitario()) %>&euro;</td>
                             <td class="center"><%= prodotto.getQuantitaAcquistata() %></td>
                             <td class="center"><%= String.format("%.0f", prodotto.getIvaDettaglio()) %>%</td> <!-- Modica dettaglio prodotto nel db e nel codice -->
                             <td class="right"><%=String.format("%.2f",  prodotto.getSubtotaleDettOrdine()) %>&euro;</td>
                         </tr>
                         <%}
            %>
                     </tbody>
                 </table>
             </div>
             <div class="row">
                 <div class="col-lg-4 col-sm-5">
                 </div>
                 <div class="col-lg-4 col-sm-5 ml-auto">
                     <table class="table table-clear">
                         <tbody>
                             <tr>
                                 <td class="left">
                                     <strong class="text-dark">Sub Totale</strong>
                                 </td>
                                 <td class="right"><%= String.format("%.2f",(ordine.getTotaleOrdine()-ordine.ivaOrdine(22))) %>&euro;</td>
                             </tr>
                           
                             <tr>
                                 <td class="left">
                                     <strong class="text-dark">Iva </strong>
                                 </td>
                                 <td class="right"><%=  String.format("%.2f", ordine.ivaOrdine(22))%>&euro;</td>
                             </tr>
                             <tr>
                                 <td class="left">
                                     <strong class="text-dark">Totale</strong> </td>
                                 <td class="right">
                                     <strong class="text-dark"><%=String.format("%.2f",  ordine.getTotaleOrdine())%>&euro;</strong>
                                 </td>
                             </tr>
                         </tbody>
                     </table>
                 </div>
             </div>
         </div>
         <div class="card-footer bg-white">
             <p class="mb-0">Decorzone.com, Italia, Salerno , 84121</p>
         </div>
     </div>
 </div>


<%} %>
<div class="download-button">
<button class="btn-download" onclick="printPage()"><i class="fa fa-download"></i> Download</button>
</div>
</div>

</body>
<jsp:include page="components/common-script.jsp"></jsp:include>
<script>
function printPage() {
  window.print();
}
</script>
</html>