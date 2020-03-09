import pureconfig._
import pureconfig.generic.auto._
import java.math.BigInteger
import org.web3j.protocol.http.HttpService
import org.web3j.protocol.Web3j
import org.web3j.crypto.Credentials
import io.aventus.AventusStorage
import org.web3j.codegen.SolidityFunctionWrapper
import org.web3j.protocol.ObjectMapperFactory

case class Config(
    serviceUrl: String,
    privateKey: String,
    storageAddress: String,
    gasPrice: BigInteger,
    gasLimit: BigInteger,
    version: String,
    dir: String,
    packge: String,
    contracts: List[String]
)

object Configured {
  val config = ConfigSource.file("application.conf").loadOrThrow[Config]
    val service = new HttpService(config.serviceUrl)
    val web3j = Web3j.build(service)
    val credentials = Credentials.create(config.privateKey)
    val storage = new Storage(
      AventusStorage.load(
        config.storageAddress,
        web3j,
        credentials,
        config.gasPrice,
        config.gasLimit
      ),
      config.version
    )
    val writer = new ContractWriter(
      storage,
      ObjectMapperFactory.getObjectMapper(),
      new SolidityFunctionWrapper(true),
      config.dir,
      config.packge
    )
}
