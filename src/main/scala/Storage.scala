import io.aventus.AventusStorage
import Hashes.hash

class Storage(val storage: AventusStorage, val version: String) {
  def withVersion(key: String) = s"${key}-${version}"

  def addressKey(key: String) = s"${withVersion(key)}_Address"

  def abiPartKey(key: String, part: Int) =
    s"${withVersion(key)}_Abi_Part_${part}"

  def numPartsKey(key: String) = s"${withVersion(key)}_Abi_NumParts"

  def address(key: String) = storage.getAddress(hash(key)).send()

  def uint(key: String) = storage.getUInt(hash(key)).send()

  def string(key: String) = storage.getString(hash(key)).send()

  def numParts(key: String) = uint(numPartsKey(key)).intValue()

  def abiPart(key: String, part: Int) = string(abiPartKey(key, part))

  def abiParts(key: String): List[String] =
    Range(0, numParts(key)).map(abiPart(key, _)).toList
}