angular.module("questionario").controller("questionarioCTRL", function($scope, questionarioAPI){
	$scope.questionario = [];
	$scope.questionario.questoes = [];
	$scope.questao = [];
	$scope.questao.alternativas = [];
	$scope.alternativa = [];
	
	
	$scope.incluiAlternativa = function(alternativa){
		$scope.questao.alternativas.push(alternativa);
		$scope.alternativa = [];
		
	}
	
	$scope.incluiQuestao = function(questao){
		$scope.questionario.questoes.push(questao);
		$scope.questao = [];
		$scope.questao.alternativas = [];
		$scope.alternativa = [];
		console.log($scope.questionario)
	}
	
	$scope.salvar = function(_questionario){
		questionarioAPI.setQuestionario(_questionario).success(function(data, status){
			$scope.questionario = [];
			$scope.questionario.questoes = [];
			$scope.questao = [];
			$scope.questao.alternativas = [];
			$scope.alternativa = [];
		}).error(function(data,status){
		});
	};
});