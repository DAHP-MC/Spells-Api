package us.dahp.spellsapi.utils;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;

/**
 * @author sirNikolai
 * @since 04/10/2020
 */
public class ServerMockUtils {
    private static ServerMock serverInstance;

    private ServerMockUtils() {}

    public static ServerMock getServerMockSafe() {
        if(MockBukkit.isMocked()) {
            serverInstance = MockBukkit.getMock();
        } else {
            serverInstance = MockBukkit.mock();
        }

        return serverInstance;
    }
}
