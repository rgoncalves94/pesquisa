angular.module("questionario").controller("questionarioCTRL", function($scope, questionarioAPI){
	
	
	$scope.incluiAlternativa = function(questao, alternativa){
		console.log(questao.alternativas)
		if (questao.alternativas == undefined){
			console.log("definido")
			var aux = [];
			aux.push(alternativa);
			console.log(questao , alternativa)
			questao.alternativas = aux;			
		}else{
			console.log("indefinido")
			questao.alternativas.push(alternativa);
		}
		delete alternativa;
	}
	
	$scope.incluiQuestao = function(questionario, questao){
		if(questionario.questoes == undefined){
			var aux = [];
			aux.push(questao);
			questionario.questoes = aux;
		}else{
			questionario.questoes.push(questao);
		}
		delete questao;
	}
	
	$scope.salvar = function(_questionario){
		questionarioAPI.setQuestionario(_questionario).success(function(data, status){
			console.log($scope.questionario)
			$scope.questionario.questoes = [];
			$scope.questao.alternativas = [];
		}).error(function(data,status){
		});
	};
});