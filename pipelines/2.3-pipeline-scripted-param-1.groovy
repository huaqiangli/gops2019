// need to define the parameters in pipeline job configure
node {
   stage('check parameters') { 
	  echo "check the parameters:"
	  echo "string parameter : ${params.String_param}"
          echo "boolean parameter: ${params.Boolean_param}"
	  echo "choice parameter: ${params.Choice_param}"
   }
}
