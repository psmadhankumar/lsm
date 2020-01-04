package io.db.lsm.factory;

import io.db.lsm.indexes.IndexMaintainer;
import io.db.lsm.indexes.IndexMaintainerImpl;

public class IndexFactory {
    static IndexMaintainer indexMaintainer = null;

    private void IndexFactory() {}

    /**
     * Provides the Index maintainer
     *
     * @return
     */
    public static IndexMaintainer getIndexMaintainerInstance() {
        return indexMaintainer != null ? indexMaintainer : new IndexMaintainerImpl();
    }
}
