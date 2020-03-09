# generate-aventus-contracts
Generates the Java Contract Wrappers for the Aventus Protocol directly from the ABI in the protocol
(as opposed to ABI on the file system).

## Configuration

Here is a template for the configuration.

`application.conf` (in the root of the project)
```properties
{
    service-url = "https://mainnet.infura.io/v3/<your infura id>"
    private-key = "0x1111111111111111111111111111111111111111111111111111111111111111"
    storage-address = "0xd6589f7CB6AE49f77ee9F666fF8AB84a91c07133"
    gas-price = "10000000000"
    gas-limit = "7000000"
    version = "0.14"
    dir = "./src/main/java"
    packge = "io.aventus"
    contracts = [
        IEventsManager,
        IAVTManager,
        IValidatorsManager,
        IMerkleRootsManager
        IFTScalingManager
    ]
}

```

## Run

`sbt run`
