import com.fasterxml.jackson.databind.ObjectMapper
import org.web3j.codegen.SolidityFunctionWrapper
import org.web3j.codegen.TruffleJsonFunctionWrapperGenerator.Contract
import collection.JavaConverters._

class ContractWriter(
    val storage: Storage,
    val mapper: ObjectMapper,
    val generator: SolidityFunctionWrapper,
    val dir: String,
    val packge: String
) {
  def save(contract: String): Unit = {
    val abi = storage
      .abiParts(contract)
      .map(abi => s""" { "abi": ${abi} } """)
      .map(mapper.readValue(_, classOf[Contract]))
      .flatMap(contract => contract.getAbi.asScala)
    if (!abi.isEmpty) {
      generator.generateJavaFiles(
        contract,
        "",
        abi.asJava,
        dir,
        packge,
        Map().asJava
      )
    }
  }

  def save(contracts: List[String]): Unit = contracts.foreach(save)
}
