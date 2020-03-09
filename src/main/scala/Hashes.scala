import org.web3j.crypto.Hash

object Hashes {
  def hash(str: String) = Hash.sha3(str.getBytes())
}
