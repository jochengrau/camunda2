package groovy

/**
 * Created by jochen on 19May16.
 */

println 'Groovy script called by task!'
println 'manual: ' + execution.getVariable('manual')
println 'first: ' + execution.getVariable('first').toString()

execution.setVariable('groovy_result', 42)
