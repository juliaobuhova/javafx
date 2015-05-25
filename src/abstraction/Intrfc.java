package abstraction;

import object.Client;

/**
 * Created by Юлия on 06.05.2015.
 */
public interface Intrfc {
    void insert(Client client);
    void update(Client client);
    void remove(Client client);
}
