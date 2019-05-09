package com.atherys.npcsmodule.script;

import com.atherys.script.api.library.LibraryExtension;
import com.atherys.script.api.library.ScriptLibrary;

public class NpcLibrary implements LibraryExtension {
    @Override
    public void extend(ScriptLibrary library) {
        library.put("getNpc", new GetNpc());
        library.put("getNpcUUID", new GetNpcUUID());
    }
}
