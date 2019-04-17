$(function(){
		$(".ajax").click(function( e ){
			e.preventDefault();
			var href = $( this ).attr('href');
			$(".container-ajax").load(href);			
		});	
});

$(function(){
	$("#formControlSelectTipoItem").change(function(element){
		var tipo = document.getElementById('formControlSelectTipoItem').value;
		
		if (tipo == "HQ") {			
			$(function(){
				$("#formControlSelectHQUniverso").change(function(element){
					var universo = document.getElementById('formControlSelectHQUniverso').value;
					$(".ajaxTabela").load("dashboard/" + tipo + "/" + universo);
				});	
			});			
		} else {
			$(".ajaxTabela").load("dashboard/" + tipo);
		}	
		
	});	
});

$('#infoModal').on('show.bs.modal', function (event) {
	var button = $(event.relatedTarget)	
	var titulo = button.data('whatevertitulo') 
	var precoVenda = button.data('whatever')
	var observacoes = button.data('whateverobservacaoes')
	var id = button.data('whateverid')
	var modal = $(this)
	 
	modal.find('.modal-title').text(titulo)
	modal.find('#recipient-precoVenda').val(precoVenda)
	modal.find('#recipient-obs').val(observacoes)
})

$(function(){
	  $('.date').mask('00/00/0000');
	  $('.time').mask('00:00:00');
	  $('.date_time').mask('00/00/0000 00:00:00');
	  $('.cep').mask('00000-000');
	  $('.phone').mask('0000-0000');
	  $('.phone_with_ddd').mask('(00) 0000-0000');
	  $('.phone_with_ddd_new').mask('(00) 00000-0000');
	  $('.phone_us').mask('(000) 000-0000');
	  $('.mixed').mask('AAA 000-S0S');
	  $('.cpf').mask('000.000.000-00', {reverse: true});
	  $('.cnpj').mask('00.000.000/0000-00', {reverse: true});
	  $('.money').mask('000.000.000.000.000.00', {reverse: true});
	  $('.num').mask('0000', {reverse: true});
	  $('.money2').mask("#.##0,00", {reverse: true});
	  $('.ip_address').mask('0ZZ.0ZZ.0ZZ.0ZZ', {
	    translation: {
	      'Z': {
	        pattern: /[0-9]/, optional: true
	      }
	    }
	  });
	  $('.ip_address').mask('099.099.099.099');
	  $('.percent').mask('##0,00%', {reverse: true});
	  $('.clear-if-not-match').mask("00/00/0000", {clearIfNotMatch: true});
	  $('.placeholder').mask("00/00/0000", {placeholder: "__/__/____"});
	  $('.fallback').mask("00r00r0000", {
	      translation: {
	        'r': {
	          pattern: /[\/]/,
	          fallback: '/'
	        },
	        placeholder: "__/__/____"
	      }
	    });
	  $('.selectonfocus').mask("00/00/0000", {selectOnFocus: true});
});

function addDlc() {
	var option = document.getElementById("formControlSelectDlc").value;
	if (option == "true") {
		document.getElementById("dlc").style.visibility ="visible";
	}
	if (option == "false") {
		document.getElementById("dlc").style.visibility ="hidden";
	}
}

function addHQUniverso() {
	var option = document.getElementById("formControlSelectTipoItem").value;
	if (option == "HQ") {
		document.getElementById("universoHQ").style.visibility ="visible";
	}else {
		document.getElementById("universoHQ").style.visibility ="hidden";
	}
}

function addConsole() {
	var option = document.getElementById("formControlSelectPlataforma").value;
	if (option == "CONSOLE") {
		document.getElementById("imputConsole").style.visibility ="visible";
	}
	if (option == "COMPUTADOR") {
		document.getElementById("imputConsole").style.visibility ="hidden";
	}
}

$(document).ready(function() {
	function limpa_formulário_cep() {
		// Limpa valores do formulário de cep.
		$("#rua").val("");
		$("#bairro").val("");
		$("#cidade").val("");
		$("#uf").val("");
		$("#ibge").val("");
		$("#pais").val("");
	}

	//Quando o campo cep perde o foco.
	$("#cep").blur(function() {

		//Nova variável "cep" somente com dígitos.
		var cep = $(this).val().replace(/\D/g, '');

		//Verifica se campo cep possui valor informado.
		if (cep != "") {

			//Expressão regular para validar o CEP.
			var validacep = /^[0-9]{8}$/;

			//Valida o formato do CEP.
			if(validacep.test(cep)) {

				//Preenche os campos com "..." enquanto consulta webservice.
				$("#rua").val("...");
				$("#bairro").val("...");
				$("#cidade").val("...");
				$("#uf").val("...");
				$("#ibge").val("...");
				$("#pais").val("...");

				//Consulta o webservice viacep.com.br/
				$.getJSON("https://viacep.com.br/ws/"+ cep +"/json/?callback=?", function(dados) {

					if (!("erro" in dados)) {
						//Atualiza os campos com os valores da consulta.
						$("#rua").val(dados.logradouro);
						$("#bairro").val(dados.bairro);
						$("#cidade").val(dados.localidade);
						$("#uf").val(dados.uf);
						$("#ibge").val(dados.ibge);
						$("#pais").val("Brasil");
					} //end if.
					else {
						//CEP pesquisado não foi encontrado.
						limpa_formulário_cep();
						alert("CEP não encontrado.");
					}
				});
			} //end if.
			else {
				//cep é inválido.
				limpa_formulário_cep();
				alert("Formato de CEP inválido.");
			}
		} //end if.
		else {
			//cep sem valor, limpa formulário.
			limpa_formulário_cep();
		}
	});
});