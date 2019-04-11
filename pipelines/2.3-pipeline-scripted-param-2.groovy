
properties([parameters([string(defaultValue: 'String_param_value', description: 'a string paramenter', name: 'String_param', trim: false), booleanParam(defaultValue: true, description: 'a boolean parameter', name: 'Boolean_param'), choice(choices: 'choice1\nchoice2\nchoice3', description: 'a boolean parameter', name: 'Choice_param')]), [$class: 'ThrottleJobProperty', categories: [], limitOneJobWithMatchingParams: false, maxConcurrentPerNode: 0, maxConcurrentTotal: 0, paramsToUseForLimit: '', throttleEnabled: false, throttleOption: 'project']])


node {
   stage('check parameters') { 
	  echo "check the parameters:"
	  echo "string parameter : ${params.String_param}"
          echo "boolean parameter: ${params.Boolean_param}"
	  echo "choice parameter:  ${params.Choice_param}"
   }
}
