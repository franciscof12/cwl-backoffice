interface SourcesContent {
    country: string;
    source: number;
    vertical: number;
    crawlingType: string;
    writesHDFS: boolean;
}

interface Sources {
    id: number;
    country: string;
    vertical: number;
    parserType: number;
    active: boolean;
}

interface Countries {
    id: string;
    language: string;
    currency: string;
    billingCurrency: string;
    name: string;
    isActive: boolean;
    isSandboxActive: boolean;
    similarNames: string;
}

interface Verticals {
    id: number;
    name: string;
    file: number;
}

interface ParserType {
    id: number;
    name: string;
}