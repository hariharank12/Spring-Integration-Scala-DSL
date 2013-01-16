/**
 *
 */
package hari.home.springIntegration.runner

import org.springframework.integration.dsl._

/**
 * @author hkumar3
 *
 */

object BootstrapScala {

  def springDSLMessageFlow: Unit = {
    
    val transformFlow = 
     filter {payload: String => payload == "hello"} -->
     transform { payload: String => "hello " + "scala"}
     
    val handleFlow = handle { payload: String => println(payload) }
    
    val messageFlow = transformFlow --> handleFlow
    
    messageFlow.send("hello")
    hari.home.springIntegration.runner.BootstrapScala

  }

def springDSL: Unit = {
    
    val messageFlow = 
     filter {payload: String => payload == "hello"} -->
     transform { payload: String => "hello " + "scala"} -->
     handle { payload: String => println(payload) }
 
     messageFlow.send("hello")
  }
  
  def main(args: Array[String]): Unit = {
    springDSL
    springDSLMessageFlow
    
  }

}