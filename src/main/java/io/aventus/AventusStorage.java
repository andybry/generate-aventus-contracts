package io.aventus;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.16.
 */
@SuppressWarnings("rawtypes")
public class AventusStorage extends Contract {
    public static final String BINARY = "";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_SETOWNER = "setOwner";

    public static final String FUNC_ALLOWACCESS = "allowAccess";

    public static final String FUNC_DENYACCESS = "denyAccess";

    public static final String FUNC_TRANSFERAVTTO = "transferAVTTo";

    public static final String FUNC_TRANSFERAVTFROM = "transferAVTFrom";

    public static final String FUNC_GETUINT = "getUInt";

    public static final String FUNC_SETUINT = "setUInt";

    public static final String FUNC_GETSTRING = "getString";

    public static final String FUNC_SETSTRING = "setString";

    public static final String FUNC_GETADDRESS = "getAddress";

    public static final String FUNC_SETADDRESS = "setAddress";

    public static final String FUNC_GETBYTES = "getBytes";

    public static final String FUNC_SETBYTES = "setBytes";

    public static final String FUNC_GETBYTES32 = "getBytes32";

    public static final String FUNC_SETBYTES32 = "setBytes32";

    public static final String FUNC_GETBOOLEAN = "getBoolean";

    public static final String FUNC_SETBOOLEAN = "setBoolean";

    public static final String FUNC_GETINT = "getInt";

    public static final String FUNC_SETINT = "setInt";

    public static final Event LOGSTORAGEACCESSALLOWED_EVENT = new Event("LogStorageAccessAllowed", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event LOGSTORAGEACCESSDENIED_EVENT = new Event("LogStorageAccessDenied", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Address>(true) {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected AventusStorage(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected AventusStorage(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected AventusStorage(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected AventusStorage(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<LogStorageAccessAllowedEventResponse> getLogStorageAccessAllowedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LOGSTORAGEACCESSALLOWED_EVENT, transactionReceipt);
        ArrayList<LogStorageAccessAllowedEventResponse> responses = new ArrayList<LogStorageAccessAllowedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LogStorageAccessAllowedEventResponse typedResponse = new LogStorageAccessAllowedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.accessAddress = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.accessType = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<LogStorageAccessAllowedEventResponse> logStorageAccessAllowedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, LogStorageAccessAllowedEventResponse>() {
            @Override
            public LogStorageAccessAllowedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LOGSTORAGEACCESSALLOWED_EVENT, log);
                LogStorageAccessAllowedEventResponse typedResponse = new LogStorageAccessAllowedEventResponse();
                typedResponse.log = log;
                typedResponse.accessAddress = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.accessType = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<LogStorageAccessAllowedEventResponse> logStorageAccessAllowedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LOGSTORAGEACCESSALLOWED_EVENT));
        return logStorageAccessAllowedEventFlowable(filter);
    }

    public List<LogStorageAccessDeniedEventResponse> getLogStorageAccessDeniedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LOGSTORAGEACCESSDENIED_EVENT, transactionReceipt);
        ArrayList<LogStorageAccessDeniedEventResponse> responses = new ArrayList<LogStorageAccessDeniedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LogStorageAccessDeniedEventResponse typedResponse = new LogStorageAccessDeniedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.accessAddress = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.accessType = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<LogStorageAccessDeniedEventResponse> logStorageAccessDeniedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, LogStorageAccessDeniedEventResponse>() {
            @Override
            public LogStorageAccessDeniedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LOGSTORAGEACCESSDENIED_EVENT, log);
                LogStorageAccessDeniedEventResponse typedResponse = new LogStorageAccessDeniedEventResponse();
                typedResponse.log = log;
                typedResponse.accessAddress = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.accessType = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<LogStorageAccessDeniedEventResponse> logStorageAccessDeniedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LOGSTORAGEACCESSDENIED_EVENT));
        return logStorageAccessDeniedEventFlowable(filter);
    }

    public RemoteFunctionCall<String> owner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setOwner(String _owner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETOWNER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> allowAccess(String _accessType, String _address) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ALLOWACCESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_accessType), 
                new org.web3j.abi.datatypes.Address(_address)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> denyAccess(String _accessType, String _address) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DENYACCESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_accessType), 
                new org.web3j.abi.datatypes.Address(_address)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferAVTTo(String _to, BigInteger _tokens) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERAVTTO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_tokens)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferAVTFrom(String _from, BigInteger _tokens) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERAVTFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_from), 
                new org.web3j.abi.datatypes.generated.Uint256(_tokens)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getUInt(byte[] _record) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETUINT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_record)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setUInt(byte[] _record, BigInteger _value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETUINT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_record), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getString(byte[] _record) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETSTRING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_record)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setString(byte[] _record, String _value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETSTRING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_record), 
                new org.web3j.abi.datatypes.Utf8String(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getAddress(byte[] _record) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_record)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setAddress(byte[] _record, String _value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_record), 
                new org.web3j.abi.datatypes.Address(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<byte[]> getBytes(byte[] _record) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETBYTES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_record)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicBytes>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> setBytes(byte[] _record, byte[] _value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETBYTES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_record), 
                new org.web3j.abi.datatypes.DynamicBytes(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<byte[]> getBytes32(byte[] _record) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETBYTES32, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_record)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> setBytes32(byte[] _record, byte[] _value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETBYTES32, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_record), 
                new org.web3j.abi.datatypes.generated.Bytes32(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> getBoolean(byte[] _record) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETBOOLEAN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_record)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setBoolean(byte[] _record, Boolean _value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETBOOLEAN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_record), 
                new org.web3j.abi.datatypes.Bool(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getInt(byte[] _record) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETINT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_record)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setInt(byte[] _record, BigInteger _value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETINT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_record), 
                new org.web3j.abi.datatypes.generated.Int256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static AventusStorage load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new AventusStorage(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static AventusStorage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new AventusStorage(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static AventusStorage load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new AventusStorage(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static AventusStorage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new AventusStorage(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<AventusStorage> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AventusStorage.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AventusStorage> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AventusStorage.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<AventusStorage> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AventusStorage.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AventusStorage> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AventusStorage.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class LogStorageAccessAllowedEventResponse extends BaseEventResponse {
        public String accessAddress;

        public String accessType;
    }

    public static class LogStorageAccessDeniedEventResponse extends BaseEventResponse {
        public String accessAddress;

        public String accessType;
    }
}
