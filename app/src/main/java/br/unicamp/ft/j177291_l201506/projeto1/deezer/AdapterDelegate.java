package br.unicamp.ft.j177291_l201506.projeto1.deezer;

public interface AdapterDelegate {
    /**
     * Called when an Item clicked
     * @param object The Object clicked
     */
    void onItemClick(Object object);

    /**
     * Called when All items are loaded by the Adapter
     */
    void onItemsLoadingComplete();

/**
 * Called when there is an error loading data to the Adapter
 * @param error
 */}