// useBlockedSources.tsx
import { useState, useEffect, useCallback } from 'react';
import { SourcesContent } from "@/app/promises/interfaces";

const useBlockedSources = (url: string): [SourcesContent[], () => void] => {
    const [data, setData] = useState<SourcesContent[]>([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch(url);
                const jsonData: SourcesContent[] = await response.json();
                setData(jsonData);
            } catch (error) {
                console.error('Error fetching data:', error);
                setData([]);
            }
        };

        fetchData();
    }, [url]);

    const refreshData = useCallback(async () => {
        try {
            const response = await fetch(url);
            const jsonData: SourcesContent[] = await response.json();
            setData(jsonData);
        } catch (error) {
            console.error('Error fetching data:', error);
            setData([]);
        }
    }, [url]);

    return [data, refreshData];
};

export default useBlockedSources;