pipeline {
    agent any
    parameters {
       string defaultValue: 'String_param_value', description: 'a string parameter', name: 'String_param', trim: false
       booleanParam defaultValue: true, description: 'a boolean parameter', name: 'Boolean_param'
       choice choices: 'choice1\nchoice2\nchoice3', description: 'a choice parameter', name: 'Choice_param'
    }

   stages {
      stage('check parameters') { 
          steps{
	         echo "check the parameters:"
	         echo "string parameter : ${params.String_param}"
                 echo "boolean parameter: ${params.Boolean_param}"
	         echo "choice parameter: ${params.Choice_param}"
          }
      }
   }
}
