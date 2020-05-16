package thoughtnote.com.utilz;

public class SocketHelper {
    //    static Socket mSocket;
//    static SharedPrefence sharedPrefence;
//    static String TAG = "SocketHelper";
//    static SocketListener socketDataReceiver;
//    static String pendingTypeData, typesDriversData = null;
//
//    static Long lastSocketConnected, isDriversLastListed;
//    static boolean isInsideTrip = false;

   /* public static void init(SharedPrefence prefence, SocketListener socketDataReceivers, String tag, boolean isInTrip) {

        socketDataReceiver = socketDataReceivers;
        isInsideTrip = isInTrip;
        sharedPrefence = prefence;
//        TAG = tag;
        SetSocketListener();
    }

    *//**
     * Initiate the socket Events.
     *//*
    public static void SetSocketListener() {


        if (mSocket != null)
            return;
        IO.Options opts = new IO.Options();
        opts.forceNew = true;
        opts.reconnection = true;
        opts.transports = new String[]{WebSocket.NAME};
        try {
            if (mSocket == null)
                mSocket = IO.socket(Constants.URL.SOCKET_URL, opts);
            if (!(mSocket.connected())) {
                Log.v("SocketTriggering", "xxxxxxxxxxxxxxxxxxxxx" + (mSocket != null ? ("Is connected" + mSocket.connected()) : "mSocket is Null"));
                mSocket.on(Socket.EVENT_CONNECT, onConnect);
                mSocket.on(Socket.EVENT_DISCONNECT, onDisconnect);
                mSocket.on(Socket.EVENT_CONNECT_ERROR, onConnectError);
                mSocket.on(Socket.EVENT_CONNECT_TIMEOUT, onConnectError);
                mSocket.on("types", types);
                mSocket.on("update_driver_info", update_driver_info);
                mSocket.on("trip_status", trip_status);
                mSocket.on("cancelled_request", cancelled_request);
                mSocket.on(Constants.NetworkParameters.TIME_TAKES, duration_handler);
                mSocket.connect();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static void DisconnectSocket() {
        if (mSocket == null)
            return;
        *//**********Trunning Off Socket********//*
        JSONObject object = new JSONObject();
        try {
            object.put(Constants.NetworkParameters.id, sharedPrefence.Getvalue(SharedPrefence.ID));
            object.put("socket_id", mSocket.id() + "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mSocket.emit("disconnect", object.toString());
        *//**********************************//*
        mSocket.disconnect();

        mSocket.off(Socket.EVENT_CONNECT, onConnect);
        mSocket.off(Socket.EVENT_DISCONNECT, onDisconnect);
        mSocket.off(Socket.EVENT_CONNECT_ERROR, onConnectError);
        mSocket.off(Socket.EVENT_CONNECT_TIMEOUT, onConnectError);
        mSocket.off("types", types);
        mSocket.off("update_driver_info", update_driver_info);
        mSocket.off("trip_status", trip_status);
        mSocket.off("cancelled_request", cancelled_request);
        mSocket.off(Constants.NetworkParameters.TIME_TAKES, duration_handler);
    }

    *//**
     * Update the available drivers and Formated the driver for the Logged user.
     *//*
    private static Emitter.Listener update_driver_info = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            Log.i(TAG, "SocketTriggering--update_driver_info-----");
            if (typesDriversData == null && !isInsideTrip)
                sendPendingTypes();
            if (args != null && args.length > 0 && args[0] != null && !CommonUtils.IsEmpty(args[0].toString())) {
                if (isDriversLastListed == null) {
                    getFormattedDrivers(args[0].toString());
                    isDriversLastListed = System.currentTimeMillis();
                } else {
                    //else if ((System.currentTimeMillis() - isDriversLastListed) > 2000) {
                    getFormattedDrivers(args[0].toString());
                    isDriversLastListed = System.currentTimeMillis();
                }

                // }
            }

        }
    };
    *//**
     * Socket triggers when trip was cancelled.
     *//*
    private static Emitter.Listener cancelled_request = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            Log.i(TAG, "cancelled_request");
            if (args != null && args.length > 0 && args[0] != null && !CommonUtils.IsEmpty(args[0].toString()) && socketDataReceiver != null && args != null)
                socketDataReceiver.CancelledRequest(args[0].toString());
        }
    };

    *//**
     * Socket triggers to show the time till the driver arrived.
     *//*
    private static Emitter.Listener duration_handler = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            socketDataReceiver.DurationHandler(args);
        }
    };

    *//**
     * socket emits the types details of drivers.
     *//*
    private static Emitter.Listener types = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            Log.i(TAG, "SocketTriggering---***************----types" + args[0]);
            if (socketDataReceiver != null)
                typesDriversData = args[0].toString();
            socketDataReceiver.Types(args[0].toString());
        }
    };

    *//**
     * This socket triggers when the trip status was changed.
     *//*
    private static Emitter.Listener trip_status = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            Log.i("SocketTriggering", "trip_status");
            if (socketDataReceiver != null && args != null)
                socketDataReceiver.TripStatus(args[0].toString());
        }
    };
    *//**
     * Connect the socket
     *//*
    private static Emitter.Listener onConnect = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            Log.i(TAG, "connected");
            JSONObject object = new JSONObject();
            try {
                object.put(Constants.NetworkParameters.id, sharedPrefence.Getvalue(SharedPrefence.ID));
                object.put("socket_id", mSocket.id() + "");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (socketDataReceiver != null && socketDataReceiver.isNetworkConnected()) {
                if (lastSocketConnected == null) {
                    mSocket.emit(Constants.NetworkParameters.start_connect, object.toString());
                    lastSocketConnected = System.currentTimeMillis();
                } else if ((System.currentTimeMillis() - lastSocketConnected) > 2000) {
                    mSocket.emit(Constants.NetworkParameters.start_connect, object.toString());
                    lastSocketConnected = System.currentTimeMillis();
                    if (pendingTypeData != null && !isInsideTrip)
                        sendTypes(pendingTypeData);
                }
                Log.i("SocketTriggering", "start_connect = " + object.toString() + " Connected=" + mSocket.connected());
            }*//*
            if ((System.currentTimeMillis() - lastSocketConnected) > 2000 && socketDataReceiver != null
                    && socketDataReceiver.isNetworkConnected() && mSocket != null) {
                mSocket.emit(Constants.NetworkParameters.start_connect, object.toString());
                lastSocketConnected = System.currentTimeMillis();
                Log.i(TAG, "start_connect = " + object.toString());
            }*//*
        }
    };

    *//**
     * Disconnect the socket.
     *//*
    private static Emitter.Listener onDisconnect = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            Log.i(TAG, "onDisconnect");
            if (socketDataReceiver != null)
                socketDataReceiver.OnDisconnect();
        }
    };

    *//**
     * Through the error of socket connections.
     *//*
    private static Emitter.Listener onConnectError = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            Log.i(TAG, "onConnectError");
            if (socketDataReceiver != null)
                socketDataReceiver.OnConnectError();
        }
    };

    *//**
     * @param types holds the vehicle types details
     *//*
    public static void sendTypes(String types) {
        Log.i("SocketTriggering", "get_rider_info Data--------------" + types);
        if (mSocket != null) {
            Log.i("SocketTriggering", "get_rider_info Data--------Socket=" + mSocket.connected());
            if (!mSocket.connected()) {
                SetSocketListener();
                pendingTypeData = types;
            } else if (mSocket.connected()) {
                Log.i("SocketTriggering", "get_rider_info Data----Sent----Socket=" + mSocket.connected());
                mSocket.emit("get_rider_info", types);
                pendingTypeData = null;
            }
        }
    }

    public static void sendPendingTypes() {
        if (mSocket != null) {
            Log.i("SocketTriggering", "get_rider_info Data--------Socket=" + mSocket.connected());
            if (!mSocket.connected()) {
                SetSocketListener();
            } else if (mSocket.connected()) {
                if (pendingTypeData != null && !CommonUtils.IsEmpty(pendingTypeData))
                    mSocket.emit("get_rider_info", pendingTypeData);
                pendingTypeData = null;
            }
        }
    }

    public static void sendRiderByTypes(String get_rider_by_type) {
        if (mSocket != null) {
            if (!mSocket.connected())
                SetSocketListener();
            mSocket.emit("get_rider_by_type", get_rider_by_type);
            Log.i("SocketTriggering", "get_rider_by_type--------------" + get_rider_by_type);
        }
    }

    public static boolean isSocketConnected() {
        return (mSocket != null) && mSocket.connected();
    }

    *//**
     * @return the driver types data.
     *//*
    public static String getLastLoadedTypes() {
        Log.i("SocketTriggering", "getLastLoadedTypes--------------");
        return typesDriversData;
    }

    *//**
     * @param updatedDriverInfo drivers informations.
     * @return the formatted drivers based on this we showed the Car image in MapScreen.
     *//*
    public static String getFormattedDrivers(String updatedDriverInfo) {
        String tempData = typesDriversData;
        String userID = sharedPrefence.Getvalue(SharedPrefence.ID);
        boolean isDriverFound = false;
        try {
//            JSONObject parentObject=new JSONObject(tempData);
            Log.d("SocketTriggering", "FormattedDrivers" + updatedDriverInfo);
            BaseResponse driverInfoDetails = new Gson().fromJson(updatedDriverInfo, BaseResponse.class);
            if (driverInfoDetails != null && driverInfoDetails.users.indexOf(userID) >= 0) {
                BaseResponse typesResponse = new Gson().fromJson(tempData, BaseResponse.class);
                if (typesResponse != null && typesResponse.success) {
                    if (typesResponse.getTypes() != null && typesResponse.getTypes().size() > 0) {
                        final List<Car> driverlist = new ArrayList<>();
                        for (int j = 0; j < typesResponse.getTypes().size(); j++) {
                            Type type = typesResponse.getTypes().get(j);
                            if (type != null && type.type_id == driverInfoDetails.driver.type) {
                                if (type.drivers.size() > 0) {
                                    for (int i = 0; i < type.drivers.size(); i++) {
                                        if (type.drivers.get(i).id == driverInfoDetails.driver.id) {
                                            type.drivers.set(i, driverInfoDetails.driver);
                                            isDriverFound = true;
                                            break;
                                        }
                                    }
                                }
                                if (!isDriverFound)
                                    type.drivers.add(driverInfoDetails.driver);

                                typesResponse.types.set(j, type);
                            }
                        }

                    }

                }
                if (typesResponse != null)
                    typesDriversData = new Gson().toJson(typesResponse);

            } else if (driverInfoDetails != null && driverInfoDetails.driver != null && driverInfoDetails.driver.id != null) {
                *//**
     * Removing driver when driver goes pickup location
     **//*
                BaseResponse typesResponse = new Gson().fromJson(tempData, BaseResponse.class);
                if (typesResponse != null && typesResponse.success) {
                    if (typesResponse.getTypes() != null && typesResponse.getTypes().size() > 0) {
                        final List<Car> driverlist = new ArrayList<>();
                        for (int j = 0; j < typesResponse.getTypes().size(); j++) {
                            Type type = typesResponse.getTypes().get(j);
                            if (type != null && type.type_id == driverInfoDetails.driver.type) {
                                if (type.drivers.size() > 0) {
                                    for (int i = 0; i < type.drivers.size(); i++) {
                                        if (type.drivers.get(i).id == driverInfoDetails.driver.id) {
                                            type.drivers.remove(i);
                                            break;
                                        }
                                    }
                                }
                                typesResponse.types.set(j, type);
                            }
                        }

                    }

                }
                if (typesResponse != null)
                    typesDriversData = new Gson().toJson(typesResponse);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        socketDataReceiver.Types(typesDriversData);
        return typesDriversData;
    }

    *//**
     * This is a interface of Initiating the socket.
     *//*
    public interface SocketListener {
        void Types(String typesString);

        void TripStatus(String trip_status);

        void CancelledRequest(String cancelled_request);

        boolean isNetworkConnected();

        void OnConnect();

        void OnDisconnect();

        void OnConnectError();

        void DurationHandler(Object[] args);
    }*/
}
